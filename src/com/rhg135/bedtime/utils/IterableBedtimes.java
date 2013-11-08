package com.rhg135.bedtime.utils;

import java.util.Iterator;

public class IterableBedtimes implements Iterable<Number> {

	private Integer toDrop;
	private Integer howMany;
	private Number initialHour;
	
	public IterableBedtimes(Integer minimum, Integer length, Number start) {
		this.toDrop = minimum;
		this.howMany = length;
		this.initialHour = start;
	}
	public Iterator<Number> iterator() {
		return new DropIterator<Number>(toDrop,
				new TakeIterator<Number>(toDrop + howMany,
						Bedtimes.bedtimeIterator(initialHour)));
	}
}
