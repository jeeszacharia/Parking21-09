package parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DBManager {
	
//***** New User Registration*********** 
public static int insertNewuser(GetterSetter sets) {
	
	Connection conn= ConnectionManager.getInstance().getConnection();
		int count =0;
	
	try{
		
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String sqlQuery=("INSERT INTO parking.registration (Name,VehicleNumber,PhoneNumber,password) VALUES(?,?,?,?)");

	PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
	
	//prepstmt.setInt(1, (Integer) null);
	 prepstmt.setString(1, sets.getName());
	 prepstmt.setString(2, sets.getVehicleNum());
	 prepstmt.setInt(3, sets.getMobnum());
	 prepstmt.setString(4, sets.getPwd());
	 	 		 
	 count=prepstmt.executeUpdate();

		
	 	 
	}catch(SQLException e){
		System.out.println(e);
	}
	
		
	ConnectionManager.getInstance().closeConnection();
	return count;
	
}
//********New User Registration Ends***********

//***********Issue Parking Ticket*************
public static int issueTicket(GetterSetter sets) throws ParseException {
	
	Connection conn= ConnectionManager.getInstance().getConnection();
	java.util.Date date=new java.util.Date();
    
    java.sql.Date sqlDate=new java.sql.Date(date.getTime());
   
	    
    int count =0;
	
	try{
		
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//String sqlQuery=("INSERT INTO parking.ticketissue (registrationID,dateofParking,time,Hoursrequested,parkingendtime,Amount) VALUES(?,2017-09-01,?,?,?)");
	
	String sqlQuery=("INSERT INTO parking.ticketissue1 (registrationID,dateofParking,starttime,Hoursrequested,endtimestamp,Amount,parkingStatus) SELECT ?,?,?,?,?,?,1 FROM dual WHERE (SELECT COUNT(*) as parkingStatus FROM parking.ticketissue1 WHERE parkingStatus=1)<10");
	PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
	
	
	prepstmt.setInt(1,sets.getRegID());
	prepstmt.setDate(2, sqlDate);
	prepstmt.setTimestamp(3, sets.getStarttime());
	prepstmt.setDouble(4, sets.getHrsrequest());
	System.out.println("Hors in DB Manager Isue Ticket Class"+sets.getHrsrequest());
	
	prepstmt.setTimestamp(5, sets.getParkingEndTime());
	prepstmt.setDouble(6, sets.getAmount());
	 
	count=prepstmt.executeUpdate();

	}catch(SQLException e){
		e.printStackTrace();
		
		//return e;
		
	}
	
	ConnectionManager.getInstance().closeConnection();
	return count;
	
}
//***********Issue Parking Ticket ENDS *************



//********** Login Validation Starts**************

public static boolean checklogin(GetterSetter sets){
	
	Connection conn= ConnectionManager.getInstance().getConnection();
	ResultSet myresultset;
	boolean loginSuccess = false;
	
	try{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlQuery=("SELECT *FROM parking.registration where Name=? and password=?");
		
		
		
		PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
		
		
		prepstmt.setString(1, sets.getUserName());
		prepstmt.setString(2, sets.getPassowrd());		
	
		
		myresultset=prepstmt.executeQuery();
		if(myresultset.next()){
			
			loginSuccess=true;
			
						
			}else{
				
				loginSuccess=false;
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
			
		}
			
	ConnectionManager.getInstance().closeConnection();
	return loginSuccess;
		
			
	}

//********** Login Validation Ends**************

//***************DISPLAY TICKET DETAILS***************
@SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList getTicketDetails(GetterSetter sets){
	
	java.text.SimpleDateFormat Sdf = new java.text.SimpleDateFormat("HH:mm:ss");
	
	Connection conn= ConnectionManager.getInstance().getConnection();
	ResultSet myresultset;
	@SuppressWarnings("rawtypes")
	ArrayList currentticketDetails=new ArrayList();
		
	try{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String sqlQuery=("SELECT TicketID,registrationID,dateofParking,Amount,endtimestamp FROM  parking.ticketissue1 WHERE registrationID=? and parkingStatus= 1");

		PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
				
		
		prepstmt.setInt(1,sets.getRegID());
		
		myresultset=prepstmt.executeQuery();
		
		while(myresultset.next()){
			
						
			currentticketDetails.add(myresultset.getInt("TicketID"));
			currentticketDetails.add(myresultset.getInt("registrationID"));
			currentticketDetails.add(myresultset.getDate("dateofParking"));
			currentticketDetails.add(myresultset.getDouble("Amount"));
			java.sql.Timestamp ts= myresultset.getTimestamp("endtimestamp");
			
			String endtimeInString = Sdf.format(ts);
		    currentticketDetails.add(endtimeInString);
			
					
			return currentticketDetails;					
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
			
		}
				
	ConnectionManager.getInstance().closeConnection();
	
	return currentticketDetails;
		
			
	}


//***************DISPLAY TICKET DETAILS END****************



//*************Get Available Parking Slots Starts****************

public static int getAvailableParking(){
	
	Connection conn= ConnectionManager.getInstance().getConnection();
	ResultSet myresultset;
	int slotcount = 0;
		
		
	try{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlQuery=("SELECT COUNT(*) as parkingStatus FROM parking.ticketissue1 WHERE parkingStatus=1;");

		PreparedStatement prepstmt = conn.prepareStatement(sqlQuery);
		
		//prepstmt.setInt(1,sets.getRegID());
		
		myresultset=prepstmt.executeQuery();
		
				
		if(myresultset.next()){
			
			slotcount=myresultset.getInt("parkingStatus");	
						
							
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
			
		}
	
			
	ConnectionManager.getInstance().closeConnection();
	return slotcount;

	}


//*************Get Available Parking Slots Ends****************


	

}
