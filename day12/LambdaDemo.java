package day12;


public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display1(()->{System.out.println("Exam has been written....");});
		System.out.println(display2((name,marks)->{return "Result...: "+name+" Marks: "+marks;}));
	}
	
	public static void display1(Exam exam) {
		exam.write();
	}
	
	public static String display2(Result res) {
		return res.getResult("Vicky", 100);
	}
}

//functional interface have only one method declaration

@FunctionalInterface
interface Exam{
	public void write();
}

@FunctionalInterface
interface Result{
	public String getResult(String name, int marks);
}