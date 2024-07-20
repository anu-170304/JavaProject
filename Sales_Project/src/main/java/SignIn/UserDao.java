package SignIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
private static final String JDBC_URL="jdbc:mysql://localhost:3306/Sales_db";
private static final String JDBC_USERNAME="root";
private static final String JDBC_PASSWORD="123456";

public boolean insertUser(UserPojo usp) {
	String sql="insert into users (name,email,password) values (?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try(Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql)
			) {
		ps.setString(1, usp.getName());
		ps.setString(2, usp.getEmail());
		ps.setString(3, usp.getPassword());
		
		int res=ps.executeUpdate();
		return res>0;
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
}
}
