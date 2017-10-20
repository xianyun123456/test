package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import enty.User;

public class ListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		UserDao dao = new UserDao();
		int pageSize = 5;
		String pageS = request.getParameter("page");
		int page;
		if(pageS==null||pageS.equals("")){
			page = 0;
		}else{
			page = Integer.parseInt(pageS);
		}
		List<User> list = dao.findPage(page, pageSize);
		int size = dao.findCount();
		int pages = size%pageSize==0 ? size/pageSize : size/pageSize + 1;
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("list", list);//分页内的所有用户的信息
		m.put("pages", pages);//页数
		response.getWriter().write(JSON.toJSONString(m));
		
	}
}
