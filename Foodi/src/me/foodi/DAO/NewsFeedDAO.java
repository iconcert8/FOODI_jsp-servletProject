package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewsFeedDAO {
	private static NewsFeedDAO dao = new NewsFeedDAO();

	public static NewsFeedDAO getInstance(){
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory(){
		String config = "me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;

		try{
			in = Resources.getResourceAsStream(config);
		}catch(Exception e){
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	/*public FeedVO detailNewsFeed(int feedNo){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		FeedVO detailFeed = new FeedVO();
		
		try{
			detailFeed = sqlSession.getMapper();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}*/
}	
