package day10;

public class ObjectClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Student stud1=new Student(123,"Vignesh");
		Student stud2=stud1.getStudentClone();
		stud2.name="Sai";
		stud2.regno=234;
		System.out.println("Student 1: "+stud1.name);
		System.out.println("Student 2: "+stud2.name);
		System.out.println("Memory: "+stud1+"  "+stud2);
	}

}

class Student implements Cloneable{
	int regno;
	String name;
	public Student(int regno, String name) {
		this.regno = regno;
		this.name = name;
	}
	
	public Student getStudentClone() throws CloneNotSupportedException {
		return (Student)super.clone();
	}
	
	
}