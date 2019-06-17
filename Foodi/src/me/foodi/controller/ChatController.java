package me.foodi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import me.foodi.action.Action;
import me.foodi.action.ActionForward;
import me.foodi.action.ActionJson;
import me.foodi.action.ChatListAction;
import me.foodi.action.ChatResListAction;
import me.foodi.action.ChatSelectLastMsgAction;
import me.foodi.action.ChatSendAction;

@WebServlet(urlPatterns = "/chat/view", asyncSupported = true)
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		임시 로그인 설정
		request.getSession().setAttribute("userId", "abc"); //로그인 아이디
		
		String path = getPath(request);
		ActionJson action = null;
		ActionForward forward = null;

		System.out.println("[!] chat servlet method : get | " + path);
		if (path.equals("chat/view")) {
			forward = new ActionForward();
//			?resId= 없을시
			if(request.getParameter("resId") == null) {
				action = new ChatSelectLastMsgAction();
				try {
					String resId = action.execute(request, response);
					forward.setRedirect(true);
					forward.setPath("view?resId=" + resId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {	
				forward.setRedirect(false);
				forward.setPath("/chat.jsp");
			}
			
		} else if(path.equals("chat/reslist")) {
			ChatResListAction resListAction = new ChatResListAction();
		}

		sendForward(forward, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getPath(request);
		System.out.println("[!] chat servlet method : post | " + path);
		Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("chat/reslist")) {
			ChatResListAction resListAction = new ChatResListAction();
			try {
				String arr = resListAction.execute(request, response);
				PrintWriter out = response.getWriter();
    			out.println(arr);
    			out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}		
		} else if(path.equals("chat/view")) {
			
		} else if(path.equals("chat/send")){
    		
    		ChatSendAction sendAction = new ChatSendAction();
    		
    		try{
    			String chatList = sendAction.execute(request, response);
    			System.out.println(chatList);
    			PrintWriter out = response.getWriter();
    			out.println(chatList);
    			out.flush();

    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		
		sendForward(forward, request, response);
	}
	

	public String getPath(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.substring(ctxPath.length() + 1);
		return path;
	}

	public void sendForward(ActionForward forward, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (forward != null) {
			if (forward.isRedirect()) {
				System.out.println("[!] sendRedirect : " + forward.getPath());
				response.sendRedirect(forward.getPath());
			} else {
				System.out.println("[!] dispatcher : " + forward.getPath());
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}

}
