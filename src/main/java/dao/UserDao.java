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
	//��ҳ��ѯ��dao
	public List<User> findPage(int page,int pageSize){
		List<User> list = new ArrayList<User>();
		String sql = "select * from user limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);//��ʾ��ѯ��ʼ������
			ps.setInt(2, pageSize);//��ʾ��ѯ������
			ResultSet rs = ps.executeQuery();//��ʼ��ѯ���һ�ý����
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
			throw new RuntimeException("��ѯ�û�ʧ��",e);
		}finally {
			DBUtil.close(con);
		}
		return list;
	}
	//��ѯ������
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
			DBUtil.close(con);//�黹����
		}
		return number;
	}
}
