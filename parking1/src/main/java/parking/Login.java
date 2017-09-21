package parking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GetterSetter objgetset= new GetterSetter();
		
		// TODO Auto-generated method stub
		boolean status;
		doGet(request, response);
		
		String varUserName=request.getParameter("uname");
		String varPassword=request.getParameter("password");
		
		
		//setting the username value to getterSetter methods to authenticate from DBManager.check user function.
		
		objgetset.setUserName(varUserName);
		objgetset.setPassowrd(varPassword);
		status= DBManager.checklogin(objgetset);
		if(status==true){
			
			HttpSession session = request.getSession();
			session.setAttribute("username", varUserName);
			
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);	
			
		}else{
			
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			
		}
		
		
	}

}
