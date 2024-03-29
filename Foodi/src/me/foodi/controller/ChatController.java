package me.foodi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.action.ActionForward;
import me.foodi.action.ActionJson;
import me.foodi.action.ChatAsyncAction;
import me.foodi.action.ChatDeleteMessageAction;
import me.foodi.action.ChatListAction;
import me.foodi.action.ChatNotifyAction;
import me.foodi.action.ChatResInfoAction;
import me.foodi.action.ChatResListAction;
import me.foodi.action.ChatSearchCheckAction;
import me.foodi.action.ChatSearchMemberAction;
import me.foodi.action.ChatSelectLastResIdAction;
import me.foodi.action.ChatSendAction;
import me.foodi.domain.UserInfoVO;

@WebServlet(urlPatterns = "/chat/*")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = getPath(request);
		ActionJson action = null;
		ActionForward forward = null;

//		로그인 검사
		if (request.getSession().getAttribute("loginUser") != null) {

			UserInfoVO userInfo = (UserInfoVO) request.getSession().getAttribute("loginUser");
			request.setAttribute("userId", userInfo.getUserId());

//			System.out.println("[!] chat servlet method : get | " + path);
			if (path.equals("chat/view")) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/chat.jsp");
			} else if (path.equals("chat/first")) {
				action = new ChatSelectLastResIdAction();
				try {
					String resId = action.execute(request, response);
					response.getWriter().write(resId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/notify")) {
				action = new ChatNotifyAction();
				try {
					String resId = action.execute(request, response);
					response.getWriter().write(resId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/Foodi/TestLogin.jsp");
		}

		sendForward(forward, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = getPath(request);
//		System.out.println("[!] chat servlet method : post | " + path);
		ActionJson action = null;
		ActionForward forward = null;

//		로그인 검사
		if (request.getSession().getAttribute("loginUser") != null) {

			UserInfoVO userInfo = (UserInfoVO) request.getSession().getAttribute("loginUser");
			request.setAttribute("userId", userInfo.getUserId());

			if (path.equals("chat/send")) {

				action = new ChatSendAction();

				try {
					String chatList = action.execute(request, response);
					responseJson(response, chatList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (path.equals("chat/reslist")) {
				action = new ChatResListAction();
				try {
					String arr = action.execute(request, response);
					responseJson(response, arr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/get")) {
				action = new ChatListAction();

				try {
					String chatList = action.execute(request, response);
					responseJson(response, chatList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/async")) {
				action = new ChatAsyncAction();

				try {
					String updateList = action.execute(request, response);
					responseJson(response, updateList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/searchFollow")) {
				action = new ChatSearchMemberAction();

				try {
					String updateList = action.execute(request, response);
					responseJson(response, updateList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/resInfo")) {
				action = new ChatResInfoAction();

				try {
					String updateList = action.execute(request, response);
					responseJson(response, updateList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/searchCheck")) {
				action = new ChatSearchCheckAction();

				try {
					String updateList = action.execute(request, response);
					responseJson(response, updateList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (path.equals("chat/delete")) {
				action = new ChatDeleteMessageAction();

				try {
					String updateList = action.execute(request, response);
					responseJson(response, updateList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("/Foodi/TestLogin.jsp");
		}

		sendForward(forward, request, response);
	}

	public void responseJson(HttpServletResponse response, String json) throws IOException {
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
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
