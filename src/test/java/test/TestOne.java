package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.UserDao;
import servlet.DownLoapServlet;

public class TestOne {
	@Test
	public void testFind(){
		UserDao dao = new UserDao();
		System.out.println(dao.findCount());
	}
	@Test
	public void test(){
		DownLoapServlet s = new DownLoapServlet();
		File f = new File("D://a");
		List<String> list = s.findAllFile(f,new ArrayList<String>());
		//lenght  length()   size()
		System.out.println(list);
	}
}
