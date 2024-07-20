package InsertSales;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalesController")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String spname=request.getParameter("spname");
		String target=request.getParameter("target");
		String units =request.getParameter("units");
		String status =request.getParameter("status");
		
		SalesPojo sp=new SalesPojo(spname, Integer.parseInt(target), Integer.parseInt(units), status);
		SalesDao sd=new SalesDao();
		
		if (sd.insertSales(sp)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Home.jsp");
			dispatcher.forward(request, response);
		} else {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
        dispatcher.forward(request, response);
		}
	}

}
