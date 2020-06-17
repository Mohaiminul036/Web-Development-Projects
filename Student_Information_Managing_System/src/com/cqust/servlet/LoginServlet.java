package com.cqust.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cqust.dao.StuDao;
import com.cqust.dao.UserDao;
import com.cqust.dao.impl.StuDaoImpl;
import com.cqust.dao.impl.UserDaoImpl;

import com.cqust.domain.Student;
import com.ydr.sysid.MySystemInfo;

@WebServlet(name="loginservlet",urlPatterns = "/login",loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	 public void init()
	 {
		this.getServletContext().setAttribute("myid",MySystemInfo.getMyID("EMON MD MOHAIMINUL ISLAM","2017490036"));
	 } 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();   
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao dao=new UserDaoImpl();
		boolean isSuccess=dao.login(username,password);
		if(isSuccess){
			
			 session.setAttribute("username", username);   
			StuDao stuDao=new StuDaoImpl();
			List<Student> list=stuDao.findAll();
			 session.setAttribute("list",list);
			response.sendRedirect("stu_list.jsp");
		}
		
		else{
			response.getWriter().write("User name or password is wrong,login failed!");
		}
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
