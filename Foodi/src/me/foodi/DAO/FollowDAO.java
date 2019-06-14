package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FollowVO;
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
	
	public List<FollowVO> followList(){
		List<FollowVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
		
		try{
			list = session.getMapper(FollowMapper.class).followList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
