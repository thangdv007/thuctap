
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



/**
 * @author MyPC
 *
 */
public class DBConnect {
	public Connection cn;
	public void KetNoi() throws SQLException{
		String hostName = "localhost";
		String database = "ThucTap";
		String userName = "sa";
		String password = "123456";
		// Xac dinh he quan tri co so du lieu
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			cn =  (Connection) DriverManager.getConnection("jdbc:sqlserver://"+hostName+":1433;databaseName="+database+";user="+userName+";password="+password+";trustServerCertificate=true;");
	}
	public static void main(String[] args) throws Exception {
		DBConnect  c = new DBConnect();
		c.KetNoi();
		System.out.println("ok");
	}

}
