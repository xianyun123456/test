package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import enty.Admin;

public class UpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String pwd = req.getParameter("pwd");
		AdminDao dao = new AdminDao();
		Admin a = (Admin)req.getSession().getAttribute("admin");
		a.setPwd(pwd);
		dao.updateAdmin(a);
		resp.sendRedirect("zz.html");
	}
}
