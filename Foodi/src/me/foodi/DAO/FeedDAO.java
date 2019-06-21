package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FeedVO;
import me.foodi.mapper.FeedMapper;

public class FeedDAO {
	private static FeedDAO dao = new FeedDAO();

	public static FeedDAO getInstance() {
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

	public int insertFeed(FeedVO feedVO) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = -1;
		int feedNo = 0;
		try {
			re = sqlSession.getMapper(FeedMapper.class).insertFeed(feedVO);
			if (re > 0) {
				sqlSession.commit();
				feedNo = sqlSession.getMapper(FeedMapper.class).getFeedNo(feedVO);
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
		return feedNo;
	}
}