package member.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
   //connection, close, rollback, commit
	
	   public static Connection getConnection() {
		      Connection con=null;
		      try {
		         Context ctx = new InitialContext();
		         DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
		         con=ds.getConnection();
		         con.setAutoCommit(false);
		      } catch (SQLException e) {         
		         e.printStackTrace();
		      } catch (NamingException e) {
		         e.printStackTrace();
		      }
		      return con;
		   }
// -------- close 영역
	public static void close(ResultSet rs) {
			try { if(rs != null) rs.close();} 
			catch (SQLException e) { e.printStackTrace();}
	}
	public static void close(PreparedStatement ps) {
		try { if(ps != null) ps.close();} 
		catch (SQLException e) { e.printStackTrace();}
	}
	public static void close(Connection con) {
		try { if(con != null) con.close();} 
		catch (SQLException e) { e.printStackTrace();}
	}
// --------- commit 영역
	public static void commit(Connection con) {
		try {con.commit();} 
		catch (SQLException e) {e.printStackTrace();}
	}
// --------- rollback영역
	public static void rollback(Connection con) {
		try {con.rollback();} 
		catch (SQLException e) {e.printStackTrace();}
	}
	


}
