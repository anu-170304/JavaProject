package LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Sales_db";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "123456";

	public boolean isValidate(LoginPojo lp) {
		String sql = "select* from users where name=? and password=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isValid = false;
		try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, lp.getName());
			ps.setString(2, lp.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				isValid = true;
			} else {
				System.out.println("no match found");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return isValid;
	}
}
