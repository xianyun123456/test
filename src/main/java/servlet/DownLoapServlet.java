package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class DownLoapServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String path = this.getServletContext().getRealPath("/images");
		File f = new File(path);
		List<String> list = findAllFile(f, new ArrayList<String>());
		response.getWriter().write(JSON.toJSONString(list));
	}
	public  List<String> findAllFile(File f,List<String> list){
		if(f.isDirectory()){//调用到没有文件夹为止
			File[] fs = f.listFiles();
			for(File fi : fs){
				findAllFile(fi,list);
			}
		}else{
			System.out.println(f.getName());
			list.add(f.getName());
		}
		return list;
	}
}
