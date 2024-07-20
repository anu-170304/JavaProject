package EditSales;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);

		String salespname = request.getParameter("spname");

		String tar = request.getParameter("target");
		int target = Integer.parseInt(tar);

		String un = request.getParameter("units");
		int units = Integer.parseInt(un);

		String status = request.getParameter("status");

		EditPojo ep = new EditPojo(id, salespname, target, units, status);
		EditDao ed = new EditDao();

		if (ed.editSales(ep)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
