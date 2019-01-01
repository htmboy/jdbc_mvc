package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import model.Goddess;

public class GoddessDao {

	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into imooc_goddess(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel)" + 
		"value(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.executeUpdate();
	}
	
	public void updateGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "update imooc_goddess set user_name=?,sex=?,age=?,"
				+ "birthday=?,email=?,mobile=?,create_user=?,create_date=current_date(),"
				+ "update_user=?,update_date=current_date(),isdel=? where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.setInt(10, g.getId());
		ptmt.executeUpdate();
	}
	
	public void delGoddess(Integer id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from imooc_goddess where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.executeUpdate();
	}
	
	public List<Goddess> query() throws Exception{
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select user_name, age from imooc_goddess");
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			gs.add(g);
		}
		
		return gs;
	}
	
	public Goddess query(String name) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from imooc_goddess where user_name=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();
		
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_data(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		
		return g;
	}
	
	public Goddess get(Integer id) throws SQLException {
		Goddess g = null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from imooc_goddess where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_data(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			
		}
		return g;
	}
}
