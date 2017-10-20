package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取上传后的文件的存储位置
		String path = this.getServletContext().getRealPath("/images");
		//创建工厂方法
		DiskFileItemFactory df = new DiskFileItemFactory();
		//创建文件解析器
		ServletFileUpload sf = new ServletFileUpload(df);
		//设置编码格式
		sf.setHeaderEncoding("utf-8");
		try {
			//sf.setFileSizeMax(1024*1024);//设置单个文件的最大值
			//sf.setSizeMax(1024*100);//设置所有文件最大值
			//把表单提交的所有数据通过文件解析器加载到list里面
			//包含了提交的上传文件和普通表单项
			List<FileItem> list = sf.parseRequest(request);
			System.out.println(list);
			for(FileItem it:list){//遍历集合，取出请求里面的所有数据
				if(it.isFormField()){//判断这条数据是不是普通表单项
					String name = it.getFieldName();
					String value= it.getString("utf-8");
					System.out.println(name+" "+value);
				}else{//这条数据里面装的是一个文件
					String fileName = it.getName();//取出上传文件的文件名
					String name = it.getFieldName();
					int index = fileName.lastIndexOf("\\");
					fileName = fileName.substring(index+1);
					path = createPath(fileName, path);
					File f = new File(path);
					if(!f.exists() && !f.isDirectory()){//判定文件夹是否存在
						System.out.println("这个文件不存在");
						f.mkdirs();//创建文件夹
					}
					fileName = new Date().getTime()+"_" + fileName;
					InputStream in = it.getInputStream();
					FileOutputStream fos = new FileOutputStream(path+"\\"+fileName);
					int d;
					byte[] arr = new byte[1024];//1KB
					while((d=in.read(arr))!=-1){
						fos.write(arr,0,d);
					}
					System.out.println("上传完毕，请指示");
					in.close();
					fos.close();
					it.delete();
				}
			}
		} catch (SizeLimitExceededException e) {
			e.printStackTrace();
			System.out.println("总共的文件大小超过限制");
		} catch (FileSizeLimitExceededException e){
			e.printStackTrace();
			System.out.println("单个文件大小超出限制");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} 
	}
	public String createPath(String fileName,String path){
		int hashCode = fileName.hashCode();
		int aa = hashCode >> 8;
		path = path+"\\"+hashCode+"\\"+aa;
		return path;
	}
}
