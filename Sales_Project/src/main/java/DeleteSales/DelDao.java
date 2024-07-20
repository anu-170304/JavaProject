package DeleteSales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DelDao {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Sales_db";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "123456";

	boolean deleteSales(DelPojo dp) {
		// TODO Auto-generated method stub
		String sql = "delete from sales where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1,dp.getId());
			
			int res= ps.executeUpdate();
			return res>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
}
