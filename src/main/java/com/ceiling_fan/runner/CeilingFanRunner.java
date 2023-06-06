package com.ceiling_fan.runner;

import com.ceiling_fan.model.CeilingFan;

/**
 * this class is the runner of ceiling fan
 * 
 * @author Saidarao Boggavarapu
 *
 */
public class CeilingFanRunner {

	public static void main(String[] args) {
		CeilingFan cf = new CeilingFan();
		System.out.println(cf.toString()); // off, clockwise, 0
		cf.changeDirection(); // anti-clockwise
		cf.changeSpeed(); // 1
		System.out.println(cf.toString()); // on, anti-clockwise, 1
		cf.changeSpeed(); // 2
		System.out.println(cf.toString()); // on, anti-clockwise, 2
		cf.changeSpeed(); // 3
		System.out.println(cf.toString()); // on, anti-clockwise, 3
		cf.changeSpeed(); // 0
		System.out.println(cf.toString()); // off, anti-clockwise, 0
		cf.changeSpeed(); // 1
		System.out.println(cf.toString()); // on, anti-clockwise, 1
		cf.changeSpeed(); // 2
		System.out.println(cf.toString()); // on, anti-clockwise, 2
		cf.changeSpeed(); // 3
		cf.changeDirection(); // clockwise
		System.out.println(cf.toString()); // on, clockwise, 3
		cf.changeSpeed(); // 0
		cf.changeDirection(); // anti-clockwise
		System.out.println(cf.toString()); // off, anti-clockwise, 0
	}

}
