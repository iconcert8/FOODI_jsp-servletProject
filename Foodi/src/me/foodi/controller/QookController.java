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
import me.foodi.action.QookDeleteAction;
import me.foodi.action.QookFeedListAction;
import me.foodi.action.QookInsertAction;

@WebServlet("/qook/*")
public class QookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public QookController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = uri.substring(ctxPath.length()+1);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("qook/insert")){
    		action = new QookInsertAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("qook/delete")){
    		action = new QookDeleteAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return;
    	}else if(path.equals("qook/feedList")){
    		action = new QookFeedListAction();
    		try{
    			forward = action.execute(request, response);
    		}catch (Exception e) {
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
