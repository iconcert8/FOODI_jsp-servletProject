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

	public int chatSend(ChatVO send) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = sqlSession.insert("chatSend", send);
		commitAndClose(sqlSession);
		return re;
	}
	
	public ChatVO chatSelectLastMsg(ChatVO chat) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		ChatVO lastMsg = sqlSession.selectOne("chatSelectLastMsg", chat);
		commitAndClose(sqlSession);
		return lastMsg;
	}

	public int chatUpdateCheck(Map<String, String> user) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = sqlSession.update("chatUpdateCheck", user);
		commitAndClose(sqlSession);
		return re;
	}
	
	public List<String> chatResList(String userId) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		List<String> chatResList = sqlSession.selectList("chatResList", userId);
		
		commitAndClose(sqlSession);
		return chatResList;
	}
	
}
