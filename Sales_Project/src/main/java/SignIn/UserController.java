package SignIn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserPojo usp=new UserPojo(name, email, password);
		UserDao ud=new UserDao();
		
		if (ud.insertUser(usp)) {
			RequestDispatcher dispatcher= request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		} else {
RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
dispatcher.forward(request, response);
		}
	}

}
