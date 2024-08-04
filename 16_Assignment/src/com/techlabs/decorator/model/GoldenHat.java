package com.techlabs.decorator.model;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat hat) {
		super(hat);
		// TODO Auto-generated constructor stub
	}
	
	public String getDescription() {
	return super.getDescription() + " With Golden Signature of King Kholi";	
	}
}
