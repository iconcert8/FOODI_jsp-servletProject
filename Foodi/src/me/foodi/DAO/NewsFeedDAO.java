package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
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

	public List<FeedVO> newsFeedList(FeedVO feedVO){
		List<FeedVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
	
		try{
			list = session.getMapper(NewsFeedMapper.class).listNewsFeed(feedVO);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		} 
		
		return list;
	
	}
	
	public List<ReplyVO> newsfeedReply(int feedNo){
		List<ReplyVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
		
		try{
			list = session.getMapper(NewsFeedMapper.class).newsfeedReply(feedNo);	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return list;	
	}
	
	public int insertNewsfeedReply(ReplyVO replyVO){
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		
		try{
			re = session.getMapper(NewsFeedMapper.class).insertNewsfeedReply(replyVO);
			if(re > 0){
				session.commit();
			}else{
				session.rollback();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
		return re;
	}
}

