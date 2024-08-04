package com.techlabs.component.test;

import com.techlabs.component.model.Circle;
import com.techlabs.component.model.DrawingArea;
import com.techlabs.component.model.Shape;
import com.techlabs.component.model.Triangle;

public class TestCompositePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape triangle = new Triangle();
		Shape circle = new Circle();
		
		DrawingArea drawing = new DrawingArea();
		drawing.add(triangle);
		drawing.add(circle);
		drawing.draw("Blue");	
		drawing.draw("Black");
		
		drawing.remove(circle);
	}

}
