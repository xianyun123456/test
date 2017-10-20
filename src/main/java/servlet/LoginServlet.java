package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import enty.Admin;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("adminName");
		String pwd = request.getParameter("pwd");
		Admin a = new AdminDao().findAdmin(name, pwd);
		if(a==null){
			response.sendRedirect("login.html");
		}else{
			request.getSession().setAttribute("admin", a);
			response.sendRedirect("zz.html");
		}
	}
}
