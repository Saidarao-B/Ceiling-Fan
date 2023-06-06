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