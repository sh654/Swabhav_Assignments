package com.techlabs.decorator.model;

public class HatDecorator implements IHat{

	private IHat hat;
	
	public HatDecorator(IHat hat) {
		this.hat = hat;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return hat.getName();
	}

	@Override
	public String getPrice() {
		// TODO Auto-generated method stub
		return hat.getPrice();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return hat.getDescription();
	}

	
}
