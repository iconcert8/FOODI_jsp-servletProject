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
import me.foodi.action.FollowDeleteAction;
import me.foodi.action.FollowInsertAction;
import me.foodi.action.FollowListAction;
import me.foodi.action.FollowListSearchAction;

@WebServlet("/follow/*")
public class FollowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FollowController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length()+1);
    	
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("follow/list")){
    		action = new FollowListAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}else if(path.equals("follow/listSearch")){
    		action = new FollowListSearchAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("follow/insert")){
    		action = new FollowInsertAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("follow/delete")){
    		action = new FollowDeleteAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}else{
    			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
    			rd.forward(request, response);
    		}
    	}
    	
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
