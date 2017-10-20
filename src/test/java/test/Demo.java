package test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		//File  文件类----可以表示文件，也可以表示目录
		File f = new File("D://a");//路径，但是文件是否存在，不清楚
		//boolean exists();
		//这个方法会返回一个boolean，表示该文件(夹)是否存在
		boolean b = f.exists();
		System.out.println(b);
		//boolean isDirectory();
		//该方法返回一个boolean，表示该文件(夹)是否是一个文件夹
		boolean b2 = f.isDirectory();//isFile();
		System.out.println(b2);
		//String getName();   
		//该方法返回一个String，表示该文件(夹)的名称
		//如果引用没有指向于某一个具体对象，就会空
		String fileName = f.getName();
		System.out.println(fileName);
		//File[] listFiles();
		//如果该文件是一个目录，那么这个方法会返回该目录的所有子文件
		//和子目录
		File[] arr = f.listFiles();
		//f.listFiles(filter)
		System.out.println(Arrays.toString(arr));
	}
}
