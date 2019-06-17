package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.NotifyVO;
import me.foodi.mapper.NotifyMapper;

public class NotifyDAO {

	private static NotifyDAO dao = new NotifyDAO();
	public static NotifyDAO getInstance(){
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
	
	public int notifyInsert(NotifyVO notifyVO){
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			re = session.getMapper(NotifyMapper.class).notifyInsert(notifyVO);
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
	
	public List<NotifyVO> notifyList(NotifyVO notifyVO){
		List<NotifyVO> list = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			list = session.getMapper(NotifyMapper.class).notifyList(notifyVO);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}
	
	public int notifyCntList(NotifyVO notifyVO){
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			re = session.getMapper(NotifyMapper.class).notifyCntList(notifyVO);
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
