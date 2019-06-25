package me.foodi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.action.Action;
import me.foodi.action.ActionForward;
import me.foodi.action.FeedGetAction;
import me.foodi.action.FeedNewsfeedAction;
import me.foodi.action.FeedReplyGetAction;
import me.foodi.action.FeedReplyInsertAction;
import me.foodi.action.FeedTagListAction;
import me.foodi.action.InsertFeedAction;
import me.foodi.action.MakeFeedAction;
import me.foodi.action.ModifyFeedAction;
import me.foodi.action.NewsFeedListAction;


@WebServlet("/feed/*")
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedController() { 
		super();
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.substring(ctxPath.length() + 1);

		Action action = null;
		ActionForward forward = null;

		if (path.equals("feed/insertFeed.do")) {
			action = new InsertFeedAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("feed/newsfeed")){
			action = new FeedNewsfeedAction();
			try{ 
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			} 
		}else if(path.equals("feed/newsfeedList.do")){
			action = new NewsFeedListAction();
			try{ 
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			} 
		}else if(path.equals("feed/get")){
			action = new FeedGetAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(path.equals("feed/getReply")){
			action = new FeedReplyGetAction();
			try{
				forward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return ;
		}else if(path.equals("feed/insertReply")){
			action = new FeedReplyInsertAction();
			try{
				forward = action.execute(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return ;
		}else if(path.equals("feed/listByTag")){
			action = new FeedTagListAction();
			try{
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}else if(path.equals("feed/makeFeed.do")){
			action = new MakeFeedAction();
			try{ 
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			} 
		}else if(path.equals("feed/modifyFeed.do")){
			action = new ModifyFeedAction();
			try{ 
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			} 
		}


		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
