simple ceiling fan which has two pull cords

The simple ceiling fan which has two pull cords and the following characteristics:
➤ One cord increases the speed each time it is pulled. There are 3 speed settings, and an “off” (speed 0) setting. 
   If the cord is pulled on speed 3, the fan returns to the “off” setting.

➤ One cord reverses the direction of the fan at the current speed setting. 
  Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.

➤ The ceiling fan should be “off” on December 25th all day even if the cords are pulled.

➤ You can assume the unit is always powered (no wall switch).


-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

Solution:

package com.ceiling_fan.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiling_fan.model.enums.CeilingFanDirection;
import com.ceiling_fan.model.enums.CeilingFanStatus;

/**
 * this class holds fields and behaviours of ceiling fan
 * 
 * @author Saidarao Boggavarapu
 *
 */

public class CeilingFan {
	private static final byte MAX_SPEED = 3;
	private static final byte MIN_SPEED = 1;
	private static final String checkDate = "1990-12-25";
	private CeilingFanStatus status = CeilingFanStatus.OFF;
	private CeilingFanDirection direction = CeilingFanDirection.CLOCKWISE;
	private byte speed = 0; // 0 to 3

	/**
	 * returns the status of ceiling fan
	 * 
	 * @return CeilingFanStatus
	 */
	public CeilingFanStatus getStatus() {
		return status;
	}

	/**
	 * sets the status of the ceiling fan
	 * 
	 * @Param status
	 */
	public void setStatus(CeilingFanStatus status) {
		this.status = status;
	}

	/**
	 * returns the direction of the ceiling fan
	 * 
	 * @return CeilingFanDirection
	 */
	public CeilingFanDirection getDirection() {
		return direction;
	}

	/**
	 * sets the direction of ceiling fan
	 * 
	 * @Param direction
	 */
	public void setDirection(CeilingFanDirection direction) {
		this.direction = direction;
	}

	/**
	 * returns the speed of the ceiling fan
	 * 
	 * @return byte
	 */
	public byte getSpeed() {
		return speed;
	}

	/**
	 * sets the ceiling fan speed
	 * 
	 * @Param speed
	 */
	public void setSpeed(byte speed) {
		this.speed = speed;
	}

	/**
	 * sets the speed to 0 and status to off
	 */
	public void switchOff() {
		setSpeed((byte) 0);
		setStatus(CeilingFanStatus.OFF);
	}

	/**
	 * changes the direction of the ceiling fan
	 */
	public void changeDirection() {
		if (getDirection() == CeilingFanDirection.CLOCKWISE) {
			setDirection(CeilingFanDirection.ANTI_CLOCKWISE);
		} else {
			setDirection(CeilingFanDirection.CLOCKWISE);
		}
	}

	/**
	 * changes the speed of the ceiling fan from 0 to 3 and checks the date 25th
	 * December for complete off condition
	 */
	public void changeSpeed() {
		if (dateChecker() == true) {
			switchOff();
			return;
		}
		byte currentSpeed = (byte) (getSpeed() + 1);
		if (currentSpeed >= MAX_SPEED + 1) {
			switchOff();
		} else if (currentSpeed >= MIN_SPEED && currentSpeed <= MAX_SPEED) {
			setSpeed(currentSpeed);
			setStatus(CeilingFanStatus.ON);
		}
	}

	/**
	 * checks today is 25th December or not
	 * 
	 * @return boolean
	 */

	public boolean dateChecker() {
		LocalDate checkDateThisYear = LocalDate.parse(checkDate, DateTimeFormatter.ISO_DATE)
				.withYear(LocalDate.now().getYear());
		if (LocalDate.now().isEqual(checkDateThisYear)) {
			return true;
		}
		return false;
	}

	/**
	 * returns the status, direction and speed of the ceiling fan
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "status = " + getStatus() + ",  direction = " + getDirection() + ",  speed = " + getSpeed();
	}
}

----------------------------------------------------------------------------------------------------------------------------

package com.ceiling_fan.model.enums;

/**
 * this enum holds the status of ceiling fan
 * 
 * @author Saidarao Boggavarapu
 *
 */
public enum CeilingFanStatus {
	ON, OFF
}

----------------------------------------------------------------------------------------------------------------------------

package com.ceiling_fan.model.enums;

/**
 * this enum holds the direction of ceiling fan
 * 
 * @author Saidarao Boggavarapu
 *
 */
public enum CeilingFanDirection {
	CLOCKWISE, ANTI_CLOCKWISE
}


-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

Test cases:

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



												   *-*-*-*-*-*-*-*
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|  Thank you  |-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
												   *-*-*-*-*-*-*-*