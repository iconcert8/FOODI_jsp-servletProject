package me.foodi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.action.Action;
import me.foodi.action.ActionForward;
import me.foodi.action.GoodDeleteAction;
import me.foodi.action.GoodInsertAction;

@WebServlet("/good/*")
public class GoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GoodController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length()+1);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("good/insert")){
    		action = new GoodInsertAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("good/delete")){
    		action = new GoodDeleteAction();
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
