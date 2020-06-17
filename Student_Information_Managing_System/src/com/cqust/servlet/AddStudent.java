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

@WebServlet(urlPatterns = "/addStudent")
public class AddStudent extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		StuDao stuDao=new StuDaoImpl();
		boolean ret=stuDao.addStudent(name, Integer.valueOf(age), address, gender);
		if(ret){
			//response.getWriter().write("Login successfully!");
			//1. query all student information
			
			stuDao=new StuDaoImpl();
			List<Student> list=stuDao.findAll();
			
			//2. store the list to scope object
			request.getSession().setAttribute("list", list);
			
			response.sendRedirect("stu_list.jsp");
		}
		
		else{
			response.getWriter().write("Add student failed!");
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
