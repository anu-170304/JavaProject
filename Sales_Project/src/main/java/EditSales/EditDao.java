package EditSales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EditDao {
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/Sales_db";
	private static final String JDBC_USERNAME="root";
	private static final String JDBC_PASSWORD="123456";
	
	public boolean editSales(EditPojo ep) {
		String sql="update sales set salespname=?,target=?,unitssold=?,status=? where id=?";
		
		try {
			Class.forName("com.mysql.cj.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
				PreparedStatement ps=con.prepareStatement(sql)) {
			ps.setString(1, ep.getSalespname());
			ps.setInt(2,ep.getTarget() );
			ps.setInt(3, ep.getUnitssold());
            ps.setString(4, ep.getStatus());
            ps.setInt(5, ep.getId());
             int result= ps.executeUpdate();
             return result>0;
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
}
