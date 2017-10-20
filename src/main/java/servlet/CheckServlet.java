package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import enty.Admin;

public class CheckServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String pwd = req.getParameter("pwd");
		Admin a = (Admin)req.getSession().getAttribute("admin");
		if(a.getPwd().equals(pwd)){
			resp.getWriter().write(JSON.toJSONString(1));
		}else{
			resp.getWriter().write(JSON.toJSONString(0));
		}//鲜云老师真帅
	}
	
	public void a(){
		System.out.println("鲜云老师真帅");
	}
	public void b(){
		System.out.println("沐家泽还是有一点点眼光的");
	}
}
