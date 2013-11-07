package com.rhg135.bedtime.utils;

import java.util.Iterator;

public class FunctionIterator<E> implements Iterator<E> {

	private Function<E> r;
	private E val;
	
	public boolean hasNext() {
		return true;
	}
	
	public E next() {
		val = r.run(val);
		return val;
	}
	
	public FunctionIterator(Function<E> f, E val) {
		this.r = f;
		this.val = val;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is imutable.");
	}

}
