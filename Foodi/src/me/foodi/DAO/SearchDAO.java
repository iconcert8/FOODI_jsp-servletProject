package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.SsgVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.mapper.SearchMapper;
import me.foodi.mapper.TagMapper;

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
	
	public int insertSsg(SsgVO ssg){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		try {
			re=sqlSession.getMapper(SearchMapper.class).insertSsg(ssg);
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
		return re;
	}
	
	public String[] searchSsg(String userId){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		String[] list = null;

		try {
			list=sqlSession.getMapper(SearchMapper.class).searchSsg(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public List<String> searchTag(String keyword) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> autoList = sqlSession.getMapper(SearchMapper.class).searchTag(keyword);
		sqlSession.close();
		return autoList;
	}

	public List<String> ssgCheck(Map ssgMap) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<String> ssgCheck = sqlSession.getMapper(SearchMapper.class).ssgCheck(ssgMap);
		sqlSession.close();
		return ssgCheck;
	}

	public int ssgCancel(SsgVO ssg) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = sqlSession.getMapper(SearchMapper.class).ssgCancel(ssg);
		if(re>0){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		return re;
	}
}
