package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	
	private static final String url = "jdbc:mysql://139.199.77.144:3306/imooc";
	private static final String user = "htmboy";
	private static final String password = "htmboy8@MSN.com";
	private static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// 获取数据库的连接
			conn = DriverManager.getConnection(url, user, password);
			
			// 通过数据库的连接操作数据库, 实现增删查改
			Statement stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
}
