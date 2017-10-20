package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/x-rar-compressed;charset=utf-8");
		String fileName = request.getParameter("fileName");
		String path = this.getServletContext().getRealPath("/images");
		String name = fileName.substring(fileName.lastIndexOf("_")+1);
		path = getPath(name,path)+"\\"+fileName;
		//path = path + "\\" + fileName;
		//让响应头去处理下载
		response.setHeader("content-disposition", 
				"attachment;filename=" + 
		URLEncoder.encode(name, "UTF-8"));
		FileInputStream fis = new FileInputStream(path);
		OutputStream os = response.getOutputStream();
		byte[] arr = new byte[1024*10];
		int d;
		while((d=fis.read(arr))!=-1){
			os.write(arr,0,d);
		}
		os.close();
		fis.close();
	}
	public String getPath(String fileName,String path){
		int a = fileName.hashCode();
		int b = a>>8;
		path = path+"\\"+a+"\\"+b;
		return path;
	}
}
