package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enty.Admin;
import util.DBUtil;

public class AdminDao {
	public Admin findAdmin(String name,String pwd){
		Admin a = null;
		Connection con = DBUtil.getConnection();
		String sql = "select * from admin where adminName=? and pwd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				a = new Admin();
				a.setAdminName(rs.getString("adminName"));
				a.setId(rs.getInt("id"));
				a.setLevel(rs.getInt("level"));
				a.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();//运行时异常
			throw new RuntimeException("查询用户失败",e);
		}finally{
			DBUtil.close(con);
		}
		return a;
	}
	public void updateAdmin(Admin a){
		String sql = "update admin set pwd = ? where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getPwd());
			ps.setInt(2, a.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败",e);
		}finally {
			DBUtil.close(con);
		}
	}
}
