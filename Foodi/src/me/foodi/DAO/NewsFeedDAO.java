package me.foodi.DAO;

import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.Feed;

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
	
	public Feed detailNewsFeed(int feedNo){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Feed detailFeed = new Feed();
		
		try{
			detailFeed = sqlSession.getMapper(arg0)
		}
	}
}	
