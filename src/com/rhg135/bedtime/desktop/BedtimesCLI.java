package com.rhg135.bedtime.desktop;

import com.rhg135.bedtime.utils.IterableBedtimes;

public class BedtimesCLI {
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("USAGE: java BedtimesCLI <startHour>)");
			System.exit(2);
		}
	
		final Number initialHour = Double.parseDouble(args[0]);
		for (Number t: new IterableBedtimes(6, 4, initialHour)) {
			System.out.println("Time: " + t);
		}
		System.exit(0);
	}

}