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
import me.foodi.action.InsertFeedAction;
import me.foodi.action.NewsFeedAction;
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

		} else if (path.equals("feed/newsFeed.do")) {
			action = new NewsFeedAction();
			System.out.println("ok");
			try{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("feed/newsfeedList.do")){
			action = new NewsFeedListAction();
			System.out.println("ok");
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			return ;
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
