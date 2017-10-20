package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Demo01 {
	public static void main(String[] args) {
		String d = deleteFile(new File("D://Á·Ï°"));
		System.out.println(d);
	}
	public static String deleteFile(File f){
		if(f.isDirectory()){
			File[] fs = f.listFiles();
			if(fs==null||fs.length==0){
				f.delete();
			}else{
				for(File file:fs){
					deleteFile(file);
				}
			}
		}else{
			String name = f.getName();
			if(name.endsWith(".jpg")||name.endsWith(".gif")||name.endsWith(".png")){
				copy(f);
			}
		}
		return "OK";
	}
	public static void copy(File f){
		String path = "D://images";
		path += "\\"+f.getName();
		try {
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] arr = new byte[1024*10];
			int d;
			while((d=fis.read(arr))!=-1){
				fos.write(arr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
