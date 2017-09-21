package parking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkingTimeCalculationTest {
	
		
	GetterSetter obj= new GetterSetter();
	ParkingTimeCalculation objPTC= new ParkingTimeCalculation();
	
	long requestedMinute;
	double expectedHrs;
	double Expectedamount;
	int updateDBStatusExpected;
	int actualStatus;

	@Before
	public void setUp() throws Exception {
		
		requestedMinute=30;
		expectedHrs=0.5;
		Expectedamount=0.75;
		updateDBStatusExpected=1;
				
	}

	@After
	public void tearDown() throws Exception {
		
		requestedMinute=0;
		expectedHrs=0;
		Expectedamount=0;
		updateDBStatusExpected=0;
		obj=null;
		objPTC=null;
		
	}

	@Test
	public void testCalculateTime() {
		
	obj.setUserRequestMinute(requestedMinute);	
	obj.setRegID(20);
	
	objPTC.CalculateTime(obj);

	
	assertEquals(expectedHrs,objPTC.requestTimeinHr);
		
		
	}
	

	@Test
	public void testCalParkingFee() {
		
		obj.setUserRequestMinute(requestedMinute);
		objPTC.CalculateTime(obj);
		objPTC.calParkingFee();
		assertEquals(Expectedamount,objPTC.parkingFee);
		
	}

	
}
