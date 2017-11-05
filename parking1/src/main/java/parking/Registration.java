package parking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		
		
	
		String varName=request.getParameter("name");
		String varVehicleNumber=request.getParameter("vnumber");
		int varMobileNumber=Integer.parseInt(request.getParameter("mobileno"));
		String varPassword=request.getParameter("password");
		
		GetterSetter objgetset= new GetterSetter();
		
		objgetset.setName(varName);
		objgetset.setVehicleNum(varVehicleNumber);
		objgetset.setMobnum(varMobileNumber);
		objgetset.setPwd(varPassword);
								
		doGet(request, response);
		try {
			
		int value=DBManager.insertNewuser(objgetset);
			
			if(value==1){
				String message = "Registration Successful";
				request.setAttribute("", message);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
					
			}else{
				String message = "Registration Not Successful";
				request.setAttribute("", message);
				request.getRequestDispatcher("/RegistrationPage.jsp").forward(request, response);
				
				
			}
			
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
