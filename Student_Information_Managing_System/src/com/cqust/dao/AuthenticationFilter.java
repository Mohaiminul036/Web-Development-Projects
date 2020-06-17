package com.cqust.dao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/*")
public class AuthenticationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		// false means if the session is not existed, the return null.

		HttpServletRequest in = (HttpServletRequest) request;
		String uri = in.getRequestURI();
		System.out.println(uri);
		
		   //first time ,let the access pass
		if (uri.equals("/SMS2017490036/login.jsp") || uri.equals("/SMS2017490036/login"))
		{
			chain.doFilter(request, response);
		} //not logined, then redirect to login page
		else if ((session == null) || (session.getAttribute("username") == null))  
		{
			((HttpServletResponse) response).sendRedirect("/SMS2017490036/login.jsp");
		} else {
			chain.doFilter(request, response);   //the user is logined, let the access pass
		}
		
	}
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
