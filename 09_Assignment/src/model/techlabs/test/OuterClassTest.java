package model.techlabs.test;

import model.techlabs.model.OuterClass;

public class OuterClassTest {

	   public static void main(String[] args) {
	        // Creating an instance of OuterClass
	        OuterClass outerObject = new OuterClass(10);

	        // Using outer class method
	        outerObject.outerDisplay();

	        // Creating an instance of InnerClass using the outer class instance
	        OuterClass.InnerClass innerObject = outerObject.new InnerClass(20);

	        // Using inner class method
	        innerObject.innerDisplay();
	        innerObject.accessOuterField();

	        // Using static nested class method
	        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass(30);
	        
	        OuterClass.StaticNestedClass.displayStaticNestedField();
	        
	    }
}
