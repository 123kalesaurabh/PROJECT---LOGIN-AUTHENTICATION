package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
@WebServlet("/login")
public class Launch1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		Connection con = ConnectionFactory.getCon();
		userDao uDao = new userDao();
		String res = uDao.loginuser(user, pass, con);
		HttpSession s =req.getSession();
		if(res.equals("exists"))
		{
			s.setAttribute("check", user);
			resp.sendRedirect("home.jsp");
		}
		else
		{
			resp.sendRedirect("login.html");
		}
		
	}
}
