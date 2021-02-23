  
package day6;

public class OverrideDemo {
	public static void main(String[] args) {
		
	//Upcasting
	Parent parent=new Child();
	parent.met();
	}	
}
//base class
abstract class Parent
{
	final float pi=3.14f; 
	public void met() {
		System.out.println("parent method called");
	}
}
// derived class
class Child extends Parent
{
	public void met() {
		System.out.println("child method called");
	}
}