package test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		//File  �ļ���----���Ա�ʾ�ļ���Ҳ���Ա�ʾĿ¼
		File f = new File("D://a");//·���������ļ��Ƿ���ڣ������
		//boolean exists();
		//��������᷵��һ��boolean����ʾ���ļ�(��)�Ƿ����
		boolean b = f.exists();
		System.out.println(b);
		//boolean isDirectory();
		//�÷�������һ��boolean����ʾ���ļ�(��)�Ƿ���һ���ļ���
		boolean b2 = f.isDirectory();//isFile();
		System.out.println(b2);
		//String getName();   
		//�÷�������һ��String����ʾ���ļ�(��)������
		//�������û��ָ����ĳһ��������󣬾ͻ��
		String fileName = f.getName();
		System.out.println(fileName);
		//File[] listFiles();
		//������ļ���һ��Ŀ¼����ô��������᷵�ظ�Ŀ¼���������ļ�
		//����Ŀ¼
		File[] arr = f.listFiles();
		//f.listFiles(filter)
		System.out.println(Arrays.toString(arr));
	}
}
