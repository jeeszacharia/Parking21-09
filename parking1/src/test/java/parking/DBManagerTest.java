package parking;

import java.sql.SQLException;
import java.text.ParseException;
//import java.util.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DBManagerTest extends TestCase {
	java.util.Date date;
	 java.sql.Timestamp sqlTime;
	 java.sql.Timestamp endtime;
	
	int insertexpectedValue;
	int insertactualValue;
	boolean loginactual;
	boolean loginexpected;
	int ticketactual;
	SQLException ticketactualerror;
	int ticketexpected;
	int detailsactual;
	//int detailsexpected;
	ArrayList detailsexpected=new ArrayList();
	ArrayList detailActual=new ArrayList();
	int availableactual;
	int availableexpected;
	
	GetterSetter obj = new GetterSetter();

	
	@SuppressWarnings("unchecked")
	@Before
	protected void setUp() throws Exception {
		
		 insertexpectedValue=1;
		 insertactualValue=0;
		 loginactual = true;
		 loginexpected= true;
		 ticketactual=0;
		 //ticketactualerror=null;
		 ticketexpected=1;
		 detailsactual=0;
		//detailsexpected=1;
		 availableactual=0;
		 availableexpected=9;
		 detailsexpected.add(53);
		 detailsexpected.add(13);
		 detailsexpected.add("2017-09-20");
		 detailsexpected.add(.5);
		 
		 }
	@After
	protected void tearDown() throws Exception {
		insertexpectedValue=0;
		 insertactualValue=0;
		 loginactual = false;
		 loginexpected= false;
		 ticketactual=0;
		 //ticketactualerror=null;
		 ticketexpected=0;
		 detailsactual=0;
		//detailsexpected=1;
		 availableactual=0;
		 availableexpected=0;
		 obj=null;
		
	}
	@Test
	public void testInsertNewuser() {
		
		//GetterSetter obj = new GetterSetter();
		
		obj.setName("ddd");
		obj.setVehicleNum("10");
		obj.setMobnum(666);
		obj.setPwd("bbb");
		
		insertactualValue= DBManager.insertNewuser(obj);
		
		assertEquals(insertexpectedValue, insertactualValue);		
		
		
	}
	@Test
	public void testIssueTicket() throws ParseException {
		
		obj.setRegID(4);
		//obj.set);
		 date = new java.util.Date(); //this and below line is to get the current SQl time 
		 sqlTime=new java.sql.Timestamp(new java.util.Date().getTime());
			
		obj.setStarttime(sqlTime); 
		obj.setHrsrequest(1);
		obj.setParkingEndTime(sqlTime);
		obj.setAmount(1.5);
		
        ticketactual= DBManager.issueTicket(obj);
		
		assertEquals(ticketexpected, ticketactual);
		
		
		
	}
	
	//Below Method works for the SQLException.
	
	
//	public void testIssueTicket() throws ParseException, SQLException {
//		
//			
//			obj.setRegID(100);
//			//obj.set);
//			 date = new java.util.Date(); //this and below line is to get the current SQl time 
//			 sqlTime=new java.sql.Timestamp(new java.util.Date().getTime());
//				
//			obj.setStarttime(sqlTime); 
//			obj.setHrsrequest(1);
//			obj.setParkingEndTime(sqlTime);
//			obj.setAmount(1.5);
//			ticketactualerror= DBManager.issueTicket(obj);
//		
//			
//			assertTrue(ticketactualerror, "java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`parking`.`ticketissue1`, CONSTRAINT `registrationID` FOREIGN KEY (`registrationID`) REFERENCES `registration` (`registrationID`) ON DELETE NO ACTION ON UPDATE NO ACTION)");
//				
//			
//			
//		}
		
		

	//private void assertTrue(SQLException ticketactualerror2, String string) {
	// TODO Auto-generated method stub
	
//}
	
	@Test
	public void testChecklogin() {

		
obj.setUserName("Jees");
obj.setPassowrd("abc");

loginactual= DBManager.checklogin(obj);

assertEquals(loginexpected, loginactual);	
		
	}

	@Test
	public void testGetAvailableParking() {
		
		
availableactual= DBManager.getAvailableParking();
		
		assertEquals(availableexpected, availableactual);		
			
		
		
	}
	
	@Test
public void testgetTicketDetails(){
	
	obj.setRegID(13);
	
	
	
	detailActual=DBManager.getTicketDetails(obj);
	
	assertArrayEquals(detailsexpected,detailActual);
	
}
	
	private void assertArrayEquals(ArrayList detailsexpected, ArrayList detailActual) {
		// TODO Auto-generated method stub
		
	}


	

}
