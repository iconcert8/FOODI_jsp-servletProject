package me.foodi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("*")
public class EncFilter implements Filter {


    public EncFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		boolean loginFlag = false;
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
//		System.out.println(requestURI);
//		System.out.println(contextPath);
		String path = requestURI.substring(contextPath.length() + 1);
		
		System.out.println(path);
		
//		test용
		if(path.indexOf("Test") != -1) {
			System.out.println("test");
			loginFlag = true;
		} else
		if(path.indexOf("userInfo") != -1) {
			loginFlag = true;
		} else if(path.indexOf("main") != -1) {
			loginFlag = true;
		} else if(httpRequest.getSession().getAttribute("loginUser") != null){
			loginFlag = true;
		}
		
		
		
		if(loginFlag) {
			chain.doFilter(request, response);
		} else {	
			httpResponse.sendRedirect("/Foodi/TestLogin.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
