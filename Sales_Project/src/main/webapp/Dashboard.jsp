<!DOCTYPE html>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html lang="en">
<head>
<title>Home</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<%
String JDBC_URL = "jdbc:mysql://localhost:3306/Sales_db";
String JDBC_USERNAME = "root";
String JDBC_PASSWORD = "123456";

Class.forName("com.mysql.cj.jdbc.Driver");
try {
	Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
	String sql = "SELECT * FROM sales";
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
.center-table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<header>
		<!-- place navbar here -->
		<nav class="navbar navbar-expand-sm navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav me-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link active"
							href="Home.jsp" aria-current="page">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="InsertSales.jsp" aria-current="page">Insert</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="Dashboard.jsp" aria-current="page">Dashboard</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main>
		<div class="container-fluid my-5">
			<center>
				<h1>DashBoard</h1>
			</center>
			<div class="table-responsive">
				<table class="table table-light center-table">
					<thead>
						<tr>
							<th scope="col">Sales Person Name</th>
							<th scope="col">Target</th>
							<th scope="col">No. of Units Sold</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
						while (rs.next()) {
						%>
						<tr class="">
							<td scope="row"><%=rs.getString("salespname")%></td>
							<td><%=rs.getInt("target")%></td>
							<td><%=rs.getInt("unitssold")%></td>
							<td><%=rs.getString("status")%></td>
							<td><a name="" id="" class="btn btn-light" href="Edit.jsp?id=<%= rs.getInt("id") %>"
								role="button">update</a>
								<a name="" id="" class="btn btn-light" href="DelController?id=<%= rs.getInt("id") %>"
								role="button">delete</a>
								</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
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
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>
