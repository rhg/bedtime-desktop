package com.rhg135.bedtime.utils;

import java.util.Iterator;

public class Bedtimes implements Iterable<Number> {

	public Number initialHour;
	
	public Bedtimes(Number start) {
		initialHour = start;
	}

	public Iterator<Number> iterator() {
		Function<Number> f = new REMCycles();
		return new DropIterator<Number>(1, new FunctionIterator<Number>(f, initialHour));
	}
	
	public static Iterator<Number> bedtimeIterator(Number initialHour) {
		return new Bedtimes(initialHour).iterator();
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("USAGE: java Bedtimes <startHour>)");
			System.exit(2);
		}
		
		final Number initialHour = Double.parseDouble(args[0]);
		Iterable<Number> it = new Iterable<Number>() {
			public Iterator<Number> iterator() {
				return new TakeIterator<Number>(6, bedtimeIterator(initialHour));
			}
		};
		for (Number t: it) {
			System.out.println("Time: " + t);
		}
		System.exit(0);
	}
}
