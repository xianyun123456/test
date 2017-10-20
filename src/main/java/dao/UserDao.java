package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import enty.User;
import util.DBUtil;

public class UserDao {
	//分页查询的dao
	public List<User> findPage(int page,int pageSize){
		List<User> list = new ArrayList<User>();
		String sql = "select * from user limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);//表示查询开始的条数
			ps.setInt(2, pageSize);//表示查询多少条
			ResultSet rs = ps.executeQuery();//开始查询并且获得结果集
			while(rs.next()){
				User u = new User();
				u.setAmount(rs.getInt("amount"));
				u.setDisplay(rs.getString("display"));
				u.setGender(rs.getString("gender"));
				u.setId(rs.getInt("id"));
				u.setPrice(rs.getDouble("price"));
				u.setPwd(rs.getString("pwd"));
				u.setUserName(rs.getString("userName"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户失败",e);
		}finally {
			DBUtil.close(con);
		}
		return list;
	}
	//查询总条数
	public int findCount(){
		String sql = "select count(*) as number from user";
		Connection con = DBUtil.getConnection();
		int number = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				number = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);//归还连接
		}
		return number;
	}
}
