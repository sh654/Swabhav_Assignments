package com.techlabs.component.model;

import java.util.ArrayList;
import java.util.List;

public class DrawingArea implements Shape{

	private List<Shape> shapes = new ArrayList<Shape>();
	
	@Override
	public void draw(String fillColor) {
		// TODO Auto-generated method stub
		for(Shape s: shapes) {
			s.draw(fillColor);
		}
	}
	
	// add shape
	public void add(Shape s) {
		this.shapes.add(s);
	}
	
	//remove
	public void remove(Shape s) {
		shapes.remove(s);
		System.out.println("Shape has be removed:"+s.getClass());
	}
	
	public void clear(Shape s) {
		shapes.clear();
		
	}
}

	
	// group of leaf and use helper to add or remove

