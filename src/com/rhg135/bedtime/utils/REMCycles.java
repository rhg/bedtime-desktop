package com.rhg135.bedtime.utils;

public class REMCycles implements Function<Number> {

	public static final double LENGTH = new Double(1.5).doubleValue();
	
	@Override
	public Number run(Object tehArgz) {
		// First, cast tehArgz to a Number
		double val = ((Number) tehArgz).doubleValue();
		return val + LENGTH;
	}

}
