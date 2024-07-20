package LogIn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		LoginPojo lp=new LoginPojo(name, password);
		LoginDao ld=new LoginDao();
		
		if (ld.isValidate(lp)) {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/Home.jsp");
            dispatcher.forward(request, response);
		} else {
          RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
          dispatcher.forward(request, response);
		}
	}

}
