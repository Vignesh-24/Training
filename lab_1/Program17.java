package lab_1;

public class Program17 {
	static int val=25;
	public final int var=2;
	Program17(int a){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Program17 object=new Program17(); 
		 * Throws Error 
		 * If the one argument constructor is not present then it will not show error
		*/
		Program17 program17=new Program17(5);
		program17.nonStaticMethod();
		
	
	}
	
	private void nonStaticMethod() {
		/*this.var=5; Could not change const */
		System.out.println("Staic varaible in Non static : "+val);
	}
	
	

}
