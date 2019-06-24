package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.mapper.TimeLineMapper;

public class TimeLineDAO {
	private static TimeLineDAO dao = new TimeLineDAO();

	public static TimeLineDAO getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}


	public List<SearchFeedVO> searchFeed(String userId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		List<SearchFeedVO> list = null;

		try {
			list=sqlSession.getMapper(TimeLineMapper.class).searchFeed(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public String[] matchTag(int feedNo){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		String[] list = null;

		try {
			list=sqlSession.getMapper(TimeLineMapper.class).matchTag(feedNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public String[] searchQook(String userId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		String[] list = null;

		try {
			list=sqlSession.getMapper(TimeLineMapper.class).searchQook(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public UserInfoVO searchUser(String userId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		UserInfoVO user = null;

		try {
			user=sqlSession.getMapper(TimeLineMapper.class).searchUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return user;
		
	}
}
