package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.UserDao;

public class PageNumberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		int pageSize = 5;
		UserDao dao = new UserDao();
		int size = dao.findCount();
		int pages = size%pageSize==0 ? size/pageSize : size/pageSize + 1;
		response.getWriter().write(JSON.toJSONString(pages));
	}
}
