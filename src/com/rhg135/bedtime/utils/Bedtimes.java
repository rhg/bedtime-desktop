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

}
