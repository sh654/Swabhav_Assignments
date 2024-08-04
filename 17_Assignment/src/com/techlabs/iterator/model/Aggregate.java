package com.techlabs.iterator.model;

public interface Aggregate<T> {
	
	Iterator<T> createIterator();
	
}
