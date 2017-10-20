package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static {

		try {
			Properties p = new Properties();

			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db-config.properties"));

			String driver = p.getProperty("driver");

			String url = p.getProperty("url");

			String username = p.getProperty("username");

			String password = p.getProperty("password");

			String init_size = p.getProperty("init_size");

			String max_size = p.getProperty("max_size");

			ds = new BasicDataSource();

			ds.setDriverClassName(driver);

			ds.setUrl(url);

			ds.setUsername(username);

			ds.setPassword(password);

			ds.setInitialSize(Integer.parseInt(init_size));

			ds.setMaxActive(Integer.parseInt(max_size));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("归还连接失败");
			}
		}
	}
	
	public static void rollback(Connection conn){
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("回滚事物失败");
			}
		}
	} 
	

}
