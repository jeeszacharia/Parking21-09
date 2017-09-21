package parking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketDetails
 */
@WebServlet("/TicketDetails")
public class TicketDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
           /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDetails() {
        super();
        
                
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GetterSetter objgetset= new GetterSetter();
		@SuppressWarnings("rawtypes")
	ArrayList arr=DBManager.getTicketDetails(objgetset);
        
       for(int i=0;i<=arr.size();i++){
			 
			 System.out.println("values"+arr);
		 }
       
        request.setAttribute("arr", arr);
		request.getRequestDispatcher("/ParkingDetails.jsp").forward(request, response);
		
		
	
	}

}
