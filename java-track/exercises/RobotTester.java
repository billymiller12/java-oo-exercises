import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTester {

	@Test
	public void testMove() {
		Robot a=new Robot("Jim", 1,1,4);
		assertTrue("problem setting coordinates in constructor",a.getX()==1);
		assertTrue("problem setting coordinates in constructor",a.getY()==1);
		a.move();
		assertTrue("problem moving",a.getY()==5);
	}
		
		@Test
		public void testRotate() {
			Robot a=new Robot("Jim", 1,1,4);
			assertTrue("Constructor initiates direction other than North",a.getDir()=="North");
			a.rotate();
			assertTrue("problem rotating",a.getDir()=="East");
		
	}
		
		@Test
		public void testGetDistance() {
			Robot a=new Robot("Jim", 1,1,4);
			Robot b=new Robot("Bob", 3,1,4);
			assertTrue("Error calculating distance",a.getDistance(b)==2);
			
		
	}

}
