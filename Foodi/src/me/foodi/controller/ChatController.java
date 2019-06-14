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
import me.foodi.action.ChatListAction;

@WebServlet("/chat/*")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getCommand(request);

		Action action = null;
		ActionForward forward = null;

		if (path.equals("chat/view")) {
			action = new ChatListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		sendForward(forward, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getCommand(request);

		Action action = null;
		ActionForward forward = null;

		if (path.equals("chat/~")) {
			action = null;
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		sendForward(forward, request, response);
	}

	private String getCommand(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String requestURI = request.getRequestURI();
		return requestURI.substring(contextPath.length() + 1);
	}

	private void sendForward(ActionForward forward, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}
