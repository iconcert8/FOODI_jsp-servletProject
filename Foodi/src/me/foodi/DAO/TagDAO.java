package me.foodi.DAO;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.TagVO;
import me.foodi.mapper.TagMapper;

public class TagDAO {
	private static TagDAO dao = new TagDAO();

	public static TagDAO getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlsessionFactory() {
		String config = "me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(config);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}

	public void insertTag(TagVO tagVO) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(TagMapper.class).insertTag(tagVO);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public List<TagVO> listHTG() {
		List<TagVO> list = null;
		SqlSession sqlSession = getSqlsessionFactory().openSession();

		try {
			list = sqlSession.getMapper(TagMapper.class).listHTG();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public List<TagVO> callTag(int feedNo) {
		List<TagVO> list = new ArrayList<>();
		SqlSession sqlSession = getSqlsessionFactory().openSession();

		try {
			list = sqlSession.getMapper(TagMapper.class).callTag(feedNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

}