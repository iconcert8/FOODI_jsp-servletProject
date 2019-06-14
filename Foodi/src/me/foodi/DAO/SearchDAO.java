package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.Feed;
import me.foodi.domain.UserInfo;
import me.foodi.mapper.SearchMapper;

public class SearchDAO {
	private static SearchDAO dao = new SearchDAO();
	public static SearchDAO getInstance(){
		return dao;
	}
	public SqlSessionFactory getSqlSessionFactory(){
		String resource="me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	public List<UserInfo> searchUser(String keyword){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<UserInfo> list = null;
		try {
			list=sqlSession.getMapper(SearchMapper.class).searchUser(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	public List<Feed> searchFeed(String keyword){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Feed> list = null;
		try {
			list=sqlSession.getMapper(SearchMapper.class).searchFeed(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
}
