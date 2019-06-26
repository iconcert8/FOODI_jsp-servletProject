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
import me.foodi.action.JoinPageAction;
import me.foodi.action.LoginPageAction;
import me.foodi.action.LogoutAction;
import me.foodi.action.TestGetAction;
import me.foodi.action.UserGetAction;


@WebServlet("/userInfo/*")
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserInfoController() {
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length()+1);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("userInfo/join.do")){
    		action = null;
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}else if(path.equals("userInfo/testGet")){
    		action = new TestGetAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}else if(path.equals("userInfo/logout.do")){
    		action = new LogoutAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("userInfo/loginPage.do")){
    		action = new LoginPageAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("userInfo/joinPage.do")){
    		action = new JoinPageAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("userInfo/get")){
	    	action = new UserGetAction();
	    	try {
	    		forward = action.execute(request, response);
	    	} catch (Exception e) {
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
