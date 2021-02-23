package day6;

public class OverrideConsDemo {
	public static void main(String[] args) {
		ParentClass parent=new ChildClass();
		parent.met();
	}
}

abstract class ParentClass
{
	public ParentClass() {
		System.out.println("Parent Class Constructor Called");
	}
	public ParentClass(int i) {
		System.out.println("Parent Class Parametrized Constructor Called");
	}
	protected void met()
	{
		System.out.println("Met method of Parent Class");
	}
}

class ChildClass extends ParentClass
{
	public ChildClass() {
		super(1);
		System.out.println("Child Class Constructor Called");
		// super(1); //not possible
	}
	public void met()
	{
		System.out.println("Met method of Child Class");
		super.met();// to call super class met() method
	}
}