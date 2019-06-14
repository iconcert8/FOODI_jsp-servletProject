package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FeedDAO {
	private static FeedDAO dao = new FeedDAO();
	
	public static FeedDAO getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlsessionFactory(){
		String config = "me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;
		
		try{
			in = Resources.getResourceAsStream(config);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	
	
	
	
	
	
	
	
	
	
}
