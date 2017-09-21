package parking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTicket
 */
@WebServlet("/GetTicket")
public class GetTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTicket() {
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
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		int ticketIssueStatus=0;
					 	
		// creating an object of getterSetter class to assign value to retrieve it DBmanager class for better management		
		GetterSetter objgetset= new GetterSetter();
		ParkingTimeCalculation objtimeCal=new ParkingTimeCalculation();
		
		//Getting the field value from jsp page
		long varMinutes = Long.parseLong(request.getParameter("Minute"));
		int varRegID=Integer.parseInt(request.getParameter("RegID"));
		//setting both values to getter and setter class to retrieve from ParkingTimeClass
		
		       objgetset.setRegID(varRegID);
              objgetset.setUserRequestMinute(varMinutes);
			

		objtimeCal.CalculateTime(objgetset);
		objtimeCal.calStartTime();
		objtimeCal.calEndTime();
		objtimeCal.calParkingFee();
		ticketIssueStatus=objtimeCal.updateToDB();
					

		if(ticketIssueStatus==0){
			
			String message = "Parking is Full Sorry!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			    		
		}else{
			
			long timeout=varMinutes*60; // Setting Timer to display Alert
			 request.setAttribute("value", timeout);//Setting timeout value for the counter in ParkingDetails.jsp
			 
			 ArrayList arr=DBManager.getTicketDetails(objgetset);
			 
			 for(int i=0;i<=arr.size();i++){
				 
				 System.out.println("values"+arr);
			 }
			 
			 request.setAttribute("arr", arr);
			 
			 request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			
			
		}
	   	   
	   	
		
				
//		// After inserting the value redirecting to home page again.
//		String message = "Ticket Issue Successful";
//		request.setAttribute("", message);
//		request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
		
		
	}

}
