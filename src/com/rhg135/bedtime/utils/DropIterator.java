package com.rhg135.bedtime.utils;

import java.util.Iterator;

public class DropIterator<E> implements Iterator<E> {

	private Iterator<E> it;
	
	public DropIterator(Integer toDrop, Iterator<E> it) {
		while (toDrop > 0) {
			it.next();
			toDrop--;
		}
		this.it = it;
		}

	public boolean hasNext() {
		return it.hasNext();
	}
	
	public E next() {
		return it.next();
	}
	
	public void remove() {
		it.remove();
	}
}
