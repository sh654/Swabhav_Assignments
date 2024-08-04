package model.techlabs.model;

public class AccessModifiersDemo {

	public int publicVar = 1;
	private int privateVar = 2;
	protected int protectedVar = 3;
	
	int defaultVar = 4; //default no modifier accessible within same class
	
	
	public void publicMethod() {
        System.out.println("Public method called");
    }

    // Private method accessible only within this class
    private void privateMethod() {
        System.out.println("Private method called");
    }

    // Protected method accessible within the same package and subclasses
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    // Default (package-private) method accessible within the same package
    void defaultMethod() {
        System.out.println("Default method called");
    }
    
    public void display() {
    	privateMethod();
    }
}
