package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDAO {

//	public static Connection ConnectDB() {
//		Connection conn = null;
//		
//		try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUANLYTTTINHOC;user=sa;password=12345678");            
//            
//        } catch (ClassNotFoundException | SQLException e) {
//            return null;
//        }
//		
//		return conn;
//	}
//	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
    static final String DB_URL = "jdbc:mysql://localhost/quanlytrungtamtinhoc?useUnicode=true&characterEncoding=UTF-8";
	//static final String DB_URL = "jdbc:mysql://node5689-trungtamtinhoc.ocs.opusinteractive.io/quanlytrungtamtinhoc?useUnicode=true&characterEncoding=UTF-8";
	
    static final String User = "root";
    
    static final String Pass = "12345678";
    //static final String Pass = "ORVmsc31816";
	    
	public static Connection ConnectDB() {
		Connection conn = null;
		
		try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, User, Pass);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
		
		return conn;
	}

}
