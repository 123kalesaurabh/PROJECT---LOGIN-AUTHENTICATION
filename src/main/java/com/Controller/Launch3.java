package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
@WebServlet("/signup")
public class Launch3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		Connection con = ConnectionFactory.getCon();
		userDao uDao = new userDao();
		String res = uDao.signupuser(user, pass, con);
		
		if(res.equals("inserted"))
		{
			resp.sendRedirect("login.html");
		}
		else
		{
			resp.sendRedirect("signup.html");
		}
		
		
	}
}
