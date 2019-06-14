package me.foodi.DAO;

public class NewsFeedDAO {
	private static NewsFeedDAO dao = new NewsFeedDAO();
	
	public static NewsFeedDAO getInstance(){
		return dao;
	}
}	
