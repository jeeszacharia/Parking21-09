package parking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DBManagerTest.class, ParkingTimeCalculationTest.class })
public class AllTests {

}
