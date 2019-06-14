package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.mapper.SearchMapper;

public class SearchDAO {
	private static SearchDAO dao = new SearchDAO();

	public static SearchDAO getInstance() {
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

	public List<UserInfoVO> searchUser(SearchVO search){

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<UserInfoVO> list = null;
		try {
			list=sqlSession.getMapper(SearchMapper.class).searchUser(search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SearchFeedVO> searchFeed(SearchVO search){

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<SearchFeedVO> list = null;
		try {
			list=sqlSession.getMapper(SearchMapper.class).searchFeed(search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	public void insertSearch(SearchVO search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		try {
			re=sqlSession.getMapper(SearchMapper.class).insertSearch(search);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}
