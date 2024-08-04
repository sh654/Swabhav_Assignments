package com.techlabs.component.model;

public class Triangle implements Shape{
	
	@Override
	public void draw(String fillColor) {
		// TODO Auto-generated method stub
		System.out.println("Drawing Triangle with color "+fillColor);
	}
	
	//leaf implement base component and building block 
	
}
