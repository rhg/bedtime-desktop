package com.rhg135.bedtime.desktop;

import java.util.Iterator;

import com.rhg135.bedtime.utils.Bedtimes;
import com.rhg135.bedtime.utils.TakeIterator;

public class BedtimesCLI {
public static void main(String[] args) {
	if (args.length != 1) {
		System.err.println("USAGE: java BedtimesCLI <startHour>)");
		System.exit(2);
	}
	
	final Number initialHour = Double.parseDouble(args[0]);
	Iterable<Number> it = new Iterable<Number>() {
		public Iterator<Number> iterator() {
			return new TakeIterator<Number>(6, Bedtimes.bedtimeIterator(initialHour));
		}
	};
	for (Number t: it) {
		System.out.println("Time: " + t);
	}
	System.exit(0);
}

}
