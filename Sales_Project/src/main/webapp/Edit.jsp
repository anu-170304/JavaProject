<!DOCTYPE html>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html lang="en">
<head>
<title>SignUp</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<%
String JDBC_URL = "jdbc:mysql://localhost:3306/Sales_db";
String JDBC_USERNAME = "root";
String JDBC_PASSWORD = "123456";
String idstr=request.getParameter("id");
int id=Integer.parseInt(idstr);
String sql = "SELECT * FROM sales where id='"+id+"'";
Class.forName("com.mysql.cj.jdbc.Driver");
try {
	Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
	
	
	Statement s = con.createStatement();
	
	ResultSet rs = s.executeQuery(sql);
%>
<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<style>
#form {
	border-radius: 5%;
	padding: 20px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>

<body>
	<header>
		<!-- place navbar here -->
	</header>
	<main>
		<div class="container-fluid">
			<div class="row justify-content-center align-items-center g-2 my-5">
				<div class="col-md-6 my-5" id="form">
					<center>
						<h1>Edit Sales</h1>
					</center>
					<% if(rs.next()){ %>
					<form action="EditController" method="post">
					
					<div class="mb-3">
							 <input
								type="hidden" class="form-control" name="id" id="" value="<%= rs.getInt("id") %>"
								aria-describedby="helpId" placeholder="" />
						</div>
					
					
					
						<div class="mb-3">
							<label for="" class="form-label">Sales Person Name</label> <input
								type="text" class="form-control" name="spname" id="" value="<%= rs.getString("salespname") %>"
								aria-describedby="helpId" placeholder="" />
						</div>

						<div class="mb-3">
							<label for="" class="form-label">Target</label> <input
								type="number" class="form-control" name="target" id="" value="<%= rs.getInt("target") %>"
								aria-describedby="helpId" placeholder="" />
						</div>

						<div class="mb-3">
							<label for="" class="form-label">No. of Units sold</label> <input
								type="number" class="form-control" name="units" id="" value="<%= rs.getInt("unitssold") %>"
								aria-describedby="helpId" placeholder="" />
						</div>

						<div class="mb-3">
							<label for="gender" class="form-label">Status</label> <select
								class="form-control" name="status" id="">
								<option value="completed">completed</option>
								<option value="notcompleted">not completed</option>
							</select>
						</div>

						<button type="submit" class="btn btn-primary">Edit</button>
					</form>
					<% } %>
					<% }catch(Exception e){
						e.printStackTrace();
					} %>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<!-- place footer here -->
	</footer>
	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>
