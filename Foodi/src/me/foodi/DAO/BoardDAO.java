package me.foodi.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	//예시 파일
	
	//예시
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
