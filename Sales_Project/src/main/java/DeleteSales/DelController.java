package DeleteSales;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DelController")
public class DelController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idstr = request.getParameter("id");
        int id=Integer.parseInt(idstr);
       DelPojo dp=new DelPojo(id);
       DelDao d=new DelDao();
       if (d.deleteSales(dp)) {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Dashboard.jsp");
		dispatcher.forward(request, response);
	} else {
       RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
       dispatcher.forward(request, response);
	}
       
       
    }
}
