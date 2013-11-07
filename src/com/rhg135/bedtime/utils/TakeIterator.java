package com.rhg135.bedtime.utils;

import java.util.Iterator;

public class TakeIterator<E> implements Iterator<E> {

	private Iterator<E> it;
	private Integer left;
	
	public TakeIterator(Integer howMany, Iterator<E> it) {
		// TODO Auto-generated constructor stub
		left = howMany;
		this.it = it;
	}
	
	public boolean hasNext() {
		return (left > 0 && it.hasNext());
	}
	
	public E next() {
		if (this.hasNext()) {
			left--;
			return it.next();
		} else {
			return null;
		}
	}

	public void remove() {
		it.remove();
	}
}
