package me.foodi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.action.Action;
import me.foodi.action.ActionForward;
import me.foodi.action.NotifyCheckNewAction;
import me.foodi.action.NotifyInsertAction;
import me.foodi.action.NotifyListAction;

@WebServlet("/notify/*")
public class NotifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NotifyController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length()+1);
    	
    	request.getSession().setAttribute("loginId", "iconcert8");
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("notify/insert")){
    		action = new NotifyInsertAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("notify/list")){
    		action = new NotifyListAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("notify/checkNew")){
    		action = new NotifyCheckNewAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}
    	
    	
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
