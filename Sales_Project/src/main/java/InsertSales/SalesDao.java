package InsertSales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/Sales_db";
	private static final String JDBC_USERNAME="root";
	private static final String JDBC_PASSWORD="123456";
	
	public boolean insertSales(SalesPojo sp) {
		String sql="insert into sales ( salespname,target,unitssold,status) values (?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD );
				PreparedStatement ps=con.prepareStatement(sql)
				) {
			ps.setString(1, sp.getSpname());
			ps.setInt(2, sp.getTarget());
			ps.setInt(3, sp.getUnits());
			ps.setString(4, sp.getStatus());
			
			int result=ps.executeUpdate();
			return result>0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
