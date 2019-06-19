package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.QookVO;
import me.foodi.mapper.QookMapper;

public class QookDAO {
	
	private static QookDAO dao = new QookDAO();
	public static QookDAO getInstance(){
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
	
	public int qookInsert(QookVO qookVO){
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			re = session.getMapper(QookMapper.class).qookInsert(qookVO);
			if(re > 0){
				session.commit();
			}else{
				session.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
		return re;
	}
	
	public int qookDelete(QookVO qookVO){
		int re = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			re = session.getMapper(QookMapper.class).qookDelete(qookVO);
			if(re > 0){
				session.commit();
			}else{
				session.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
		return re;
	}
}
