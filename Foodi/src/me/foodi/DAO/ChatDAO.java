package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.ChatVO;

public class ChatDAO {
	
	private static ChatDAO instance = new ChatDAO();
	
	private ChatDAO() { }

	public static ChatDAO getInstance() {
		return instance;
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
	
	private void commitAndClose(SqlSession sqlSession) {
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public List<ChatVO> chatList(Map<String, String> user) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		List<ChatVO> chatList = sqlSession.selectList("chatList", user);
		commitAndClose(sqlSession);
		return chatList;
	}
	
}
