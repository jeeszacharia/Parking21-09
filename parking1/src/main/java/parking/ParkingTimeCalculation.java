package parking;

import java.text.ParseException;

class ParkingTimeCalculation{
		
	
	GetterSetter objgetset= new GetterSetter();	
	private double baseRate=1.5;
	
	int ticketIssueStatus=0;
	double timeRequested=0;
	double requestTimeinHr;
	double parkingFee=0;
	 int regID=0;
	 java.util.Date date;
	 java.sql.Timestamp sqlTime;
	 java.sql.Timestamp endtime;
	
	public void CalculateTime(GetterSetter sets){
	
				
		timeRequested=sets.getUserRequestMinute();// getting user time in minutes from getter setter class
		
				
		requestTimeinHr=timeRequested/60; //Converting Minutes to hrs for easy calculation.
		
		regID=sets.getRegID(); // Assigning the registration id to a variable to pass all the values together to GetTicket function in 
		                       //DMmanager class.
				
		//objgetset.setHrsrequest(requestTimeinHr);
		
		
									
		}
				
	
	
	public  void calStartTime(){
				
		
			 date=new java.util.Date(); //this and below line is to get the current SQl time 
		   	sqlTime=new java.sql.Timestamp(new java.util.Date().getTime());
		   	
		//objgetset.setStarttime(sqlTime);  //Assigning the start time to getter setter class
		 	
				 
					
		}
	
	public void calEndTime(){
		
		System.out.println("Time requested inside End time Function"+timeRequested);
		
		 endtime = new java.sql.Timestamp((long) (sqlTime.getTime()+((1000 * 60 * 60 )*requestTimeinHr))); // Calculating the end time based on user input.	
		//objgetset.setParkingEndTime(endtime);    		

	}
	
	public void calParkingFee(){
		
		parkingFee=(requestTimeinHr*baseRate);
		
		//objgetset.setAmount(parkingFee);
		
	}
	
	public int updateToDB(){
		//This function pass all the values getterSetter class .
	
		objgetset.setHrsrequest(requestTimeinHr);
		objgetset.setRegID(regID);
		objgetset.setStarttime(sqlTime);
		objgetset.setParkingEndTime(endtime);
		objgetset.setAmount(parkingFee);
		
		
				
	try {
			ticketIssueStatus=DBManager.issueTicket(objgetset);// Call the issueTicket function form DBmanager class and pass the object to that function to
			                                                   //retrieve data from getterSetter.
} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return ticketIssueStatus;
		
		
	}
	
}



