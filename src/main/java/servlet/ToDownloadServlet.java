package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDownloadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fileName = request.getParameter("fileName");
		String path = this.getServletContext().getRealPath("/images");
		path += "\\"+fileName;
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		FileInputStream fis = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		int d;
		byte[] arr = new byte[1024*10];
		while((d=fis.read(arr))!=-1){
			out.write(arr,0,d);
		}
		System.out.println("œ¬‘ÿÕÍ±œ");
		fis.close();
		out.close();
	}
}
