package ceiling_fan;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ceiling_fan.model.CeilingFan;
import com.ceiling_fan.model.enums.CeilingFanDirection;
import com.ceiling_fan.model.enums.CeilingFanStatus;

/**
 * this class holds test cases for methods in ceiling fan
 * 
 * @author Saidarao Boggavarapu
 *
 */

public class CeilingFanTest {
	
	CeilingFan fan = new CeilingFan();

	@Test
	public void dateCheckerTest() {
		assertFalse(fan.dateChecker());
	}
	
	
	@Test
	public void CeilingFanStatusTest1() {
		assertEquals(CeilingFanStatus.OFF, fan.getStatus());
	}

	@Test
	public void CeilingFanStatusTest2() {
		fan.setStatus(CeilingFanStatus.ON);
		assertEquals(CeilingFanStatus.ON, fan.getStatus());
	}
	
	@Test
	public void ceilingFanDirectionTest1() {
		assertEquals(CeilingFanDirection.CLOCKWISE, fan.getDirection());
	}
	
	@Test
	public void ceilingFanDirectionTest2() {
		fan.setDirection(CeilingFanDirection.ANTI_CLOCKWISE);
		assertEquals(CeilingFanDirection.ANTI_CLOCKWISE, fan.getDirection());
	}
	
	@Test
	public void ceilingFanSpeedTest1() {
		assertEquals(0,fan.getSpeed());
	}
	
	@Test
	public void ceilingFanSpeedTest2() {
		fan.setSpeed((byte) 2);
		assertEquals(2,fan.getSpeed());
	}
	
	@Test
	public void ceilingFanswitchOffTest() {
		fan.switchOff();
		assertEquals(0, fan.getSpeed());
		assertEquals(CeilingFanStatus.OFF, fan.getStatus());
	}
	
	@Test
	public void ceilingFanChangeDirectionTest1() {
		fan.changeDirection();
		assertEquals(CeilingFanDirection.ANTI_CLOCKWISE, fan.getDirection());
	}
	@Test
	public void ceilingFanChangeDirectionTest2() {
		fan.setDirection(CeilingFanDirection.ANTI_CLOCKWISE);
		fan.changeDirection();
		assertEquals(CeilingFanDirection.CLOCKWISE, fan.getDirection());
	}
	
	@Test
	public void ceilingFanChangeSpeedTest1() {
		fan.changeSpeed();
		assertEquals(1, fan.getSpeed());
	}
	
	@Test
	public void ceilingFanChangeSpeedTest2() {
		fan.setSpeed((byte) 1);
		fan.changeSpeed();
		assertEquals(2, fan.getSpeed());
	}
	
	@Test
	public void ceilingFanChangeSpeedTest3() {
		fan.setSpeed((byte) 2);
		fan.changeSpeed();
		assertEquals(3, fan.getSpeed());
	}
	
	@Test
	public void ceilingFanChangeSpeedTest4() {
		fan.setSpeed((byte) 3);
		fan.changeSpeed();
		assertEquals(0, fan.getSpeed());
	}
	
	@Test
	public void ceilingFanChangeSpeedTest5() {
		fan.setSpeed((byte) 10);
		fan.changeSpeed();
		assertEquals(0, fan.getSpeed());
	}
}