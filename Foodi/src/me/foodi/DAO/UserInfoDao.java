package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.FollowVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.mapper.UserInfoMapper;

public class UserInfoDao {
	
	private static UserInfoDao dao = new UserInfoDao();
	
	public static UserInfoDao getInstance() {
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
	
	public int userInfoInsert(UserInfoVO userInfoVO) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(UserInfoMapper.class).userInfoInsert(userInfoVO);
			if(re > 0 ) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}

	public UserInfoVO testGet(String userId){
		UserInfoVO userInfoVO = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			userInfoVO = sqlSession.getMapper(UserInfoMapper.class).testGet(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return userInfoVO;
	}
	
	public FollowInfoVO userGet(FollowVO followVO){
		FollowInfoVO followInfoVO = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			followInfoVO = sqlSession.getMapper(UserInfoMapper.class).userGet(followVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return followInfoVO;
	}

}
