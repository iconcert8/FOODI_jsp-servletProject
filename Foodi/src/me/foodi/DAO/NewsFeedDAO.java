package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FeedVO;
import me.foodi.mapper.NewsFeedMapper;


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

	public List<FeedVO> newsFeedList(){
		List<FeedVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
	
		try{
			list = session.getMapper(NewsFeedMapper.class).listNewsFeed();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	
	}
}

