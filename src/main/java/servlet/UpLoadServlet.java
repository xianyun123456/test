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
		//��ȡ�ϴ�����ļ��Ĵ洢λ��
		String path = this.getServletContext().getRealPath("/images");
		//������������
		DiskFileItemFactory df = new DiskFileItemFactory();
		//�����ļ�������
		ServletFileUpload sf = new ServletFileUpload(df);
		//���ñ����ʽ
		sf.setHeaderEncoding("utf-8");
		try {
			//sf.setFileSizeMax(1024*1024);//���õ����ļ������ֵ
			//sf.setSizeMax(1024*100);//���������ļ����ֵ
			//�ѱ��ύ����������ͨ���ļ����������ص�list����
			//�������ύ���ϴ��ļ�����ͨ����
			List<FileItem> list = sf.parseRequest(request);
			System.out.println(list);
			for(FileItem it:list){//�������ϣ�ȡ�������������������
				if(it.isFormField()){//�ж����������ǲ�����ͨ����
					String name = it.getFieldName();
					String value= it.getString("utf-8");
					System.out.println(name+" "+value);
				}else{//������������װ����һ���ļ�
					String fileName = it.getName();//ȡ���ϴ��ļ����ļ���
					String name = it.getFieldName();
					int index = fileName.lastIndexOf("\\");
					fileName = fileName.substring(index+1);
					path = createPath(fileName, path);
					File f = new File(path);
					if(!f.exists() && !f.isDirectory()){//�ж��ļ����Ƿ����
						System.out.println("����ļ�������");
						f.mkdirs();//�����ļ���
					}
					fileName = new Date().getTime()+"_" + fileName;
					InputStream in = it.getInputStream();
					FileOutputStream fos = new FileOutputStream(path+"\\"+fileName);
					int d;
					byte[] arr = new byte[1024];//1KB
					while((d=in.read(arr))!=-1){
						fos.write(arr,0,d);
					}
					System.out.println("�ϴ���ϣ���ָʾ");
					in.close();
					fos.close();
					it.delete();
				}
			}
		} catch (SizeLimitExceededException e) {
			e.printStackTrace();
			System.out.println("�ܹ����ļ���С��������");
		} catch (FileSizeLimitExceededException e){
			e.printStackTrace();
			System.out.println("�����ļ���С��������");
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
