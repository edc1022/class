package co.micol.bnhj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource { // DataSource: DAO 의 관례적 표현.
	// DB 연결위해서.
	 private String driver = "oracle.jdbc.driver.OracleDriver";
	 private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 private String user ="test";
	 private String password = "1234";
	 public Connection conn;
	 
	 public DataSource() {
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();
			}
			
	//Singleton DataSource
	/*private static DataSource dataSource = new DataSource();
	private DataSource( ) {}

	public static DataSource getInstance() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="test";
		String password = "1234";
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;*/
	}
}
