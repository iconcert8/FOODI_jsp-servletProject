package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.FollowVO;
import me.foodi.domain.SearchVO;
import me.foodi.mapper.FollowMapper;

public class FollowDAO {
	
	private static FollowDAO dao = new FollowDAO();
	public static FollowDAO getInstance(){
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
	
	public List<FollowInfoVO> followerList(SearchVO searchVO){
		List<FollowInfoVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
		
		try{
			list = session.getMapper(FollowMapper.class).followerList(searchVO);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}
	
	public List<FollowInfoVO> followingList(SearchVO searchVO){
		List<FollowInfoVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			list = session.getMapper(FollowMapper.class).followingList(searchVO);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public int followInsert(FollowVO followVO) {
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			re = session.getMapper(FollowMapper.class).followInsert(followVO);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public int followDelete(FollowVO followVO) {
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			re = session.getMapper(FollowMapper.class).followDelete(followVO);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
}
