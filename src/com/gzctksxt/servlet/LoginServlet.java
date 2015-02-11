package com.gzctksxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzctksxt.bean.User;
import com.gzctksxt.dao.UserDao;
import com.gzctksxt.daoImp.UserDaoImp;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	 UserDao ud=new UserDaoImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String  userName=req.getParameter("userName");
		String  userPassword=req.getParameter("userPassword");
		System.out.println(userName+userPassword);
	if(null!=userName&&!"".equals(userName)&&null!=userPassword&&!"".equals(userPassword))
	{
		User user=null;
		try {
			user = ud.checklogin(userName,userPassword);
			System.out.println(user);
			if(user!=null&&user.getUserName().equals(userName))
			{
				req.getSession().setAttribute("userinfo", user);
				if(user.getIsAdmin().equals("Y"))
				{
					if (user.getUserName().equals("yidong")) {
						resp.sendRedirect("fileUpDown/ydUp.jsp");
						
					}else if (user.getUserName().equals("kuandai")) {
						resp.sendRedirect("fileUpDown/kdUp.jsp");
						
					}else if (user.getUserName().equals("zhoubao")) {
						resp.sendRedirect("fileUpDown/pptUp.jsp");
						
					}else if (user.getUserName().equals("zhuanxiang")) {
						resp.sendRedirect("fileUpDown/zdUp.jsp");
						
					}

				}else
				{
					resp.sendRedirect("view2.jsp");
				}
			}
			else
			{
				resp.sendRedirect("login.jsp");;
			}
		} catch (Exception e) {
			resp.sendRedirect("login.jsp");
		}
	  }else
	  {
		  	resp.sendRedirect("login.jsp");
	  }
	}
}
