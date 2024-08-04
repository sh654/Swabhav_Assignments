package model.techlabs.model;

public class OuterClass {

	private int outerField;
	
	public OuterClass(int outerField) {
		this.outerField = outerField;
	}

	public int getOuterField() {
		return outerField;
	}

	public void setOuterField(int outerField) {
		this.outerField = outerField;
	}
	
	public void outerDisplay() {
		System.out.println("Outer Field consist of : "+ outerField);
	}
	
	//Innerclass ie non static inside main class
	public class InnerClass{
		
		private int innerField;

		public int getInnerField() {
			return innerField;
		}

		public void setInnerField(int innerField) {
			this.innerField = innerField;
		}
		
		public InnerClass(int innerField) {
			this.innerField = innerField;
		}
		
		public void innerDisplay() {
			System.out.println("Inner Field consist of : "+ innerField);
		}
		 public void accessOuterField() {
	       System.out.println("Accessing Outer Field from Inner Class: " + outerField);
		 }
	}
	
	
	public static class StaticNestedClass {
		
		private static int staticNestedField;

		public static int getStaticNestedField() {
			return staticNestedField;
		}

		public static void setStaticNestedField(int staticNestedField) {
			StaticNestedClass.staticNestedField = staticNestedField;
		}
		
		public StaticNestedClass(int staticNestedField) {
			StaticNestedClass.staticNestedField = staticNestedField;
		}
		
		public static void displayStaticNestedField() {
			System.out.println("Static Class Inner class : "+staticNestedField);
		}
		
		
		
	}
}
