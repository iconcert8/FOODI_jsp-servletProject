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
		
		System.out.println("dao0");
		
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = -1;
		
		System.out.println("dao1");
		
		try {
			
			System.out.println("dao2");
			
			re = sqlSession.getMapper(FeedMapper.class).insertFeed(feedVO);
			
			System.out.println("dao3");

			if (re > 0) {
				System.out.println("commit");
				sqlSession.commit();
			} else {
				System.out.println("rollback");
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}

}
