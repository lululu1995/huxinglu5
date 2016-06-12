package mysqlDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConnection(){
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
}
