package com.techlabs.decorator.model;

public class RibbonedHat extends HatDecorator{

	public RibbonedHat(IHat hat)
	{
		super(hat);
	}
	
	public String getDescription() {
		return super.getDescription() +" with red ribbons";
	}
	
}
