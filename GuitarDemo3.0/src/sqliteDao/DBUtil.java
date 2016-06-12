package sqliteDao;

import java.sql.*;
import java.io.*;

public class DBUtil {
	static String url="jdbc:sqlite://d:/guitar.db3";
	static Connection conn=null;
	public static Connection getConnection(){
		
		try{
			Class.forName("org.sqlite.JDBC");	
			conn=DriverManager.getConnection(url);
		}catch(ClassNotFoundException e){
			
		}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
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
