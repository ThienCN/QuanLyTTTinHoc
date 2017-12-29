package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
   
public class loginDAO {     

	public static int CheckLogin(String user, String pass, int role) {
		
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return 0;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_CheckDangNhap(?,?,?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.setString(2, user);
			cstmt.setString(3, pass);
			cstmt.setInt(4, role); 
			
			cstmt.execute();
			
			int kq=cstmt.getInt(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public static String LayTenNguoiDung(String user, int role) { 
		
		Connection conn = null;
		CallableStatement cstmt=null;     
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_LayTenNguoiDung(?,?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.NVARCHAR);
			cstmt.setString(2, user);
			cstmt.setInt(3, role); 
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
