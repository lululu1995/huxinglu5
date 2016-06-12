package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBU2 {
	public Connection getConnection(){
		String driver="com.mysql.jdbc.Driver";
		String sql="jdbc:mysql://127.0.0.1/guitar";
		Connection conn=null;
		String user = "root";  
		String password = "123456";  
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(sql,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
}
	public void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
