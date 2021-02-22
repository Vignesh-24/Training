package lab_book;

public class Question_24_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.floor(-4.7));  // Returns -5.0
		System.out.println(Math.round(-4.7));// Returns -5.0
		System.out.println(Math.ceil(-4.7)); // Returns -4.0
		//System.out.println(Math.min(-4.7)); Argument msimatch
		
		
		//25
		Integer ten=new Integer(10);  //The constructor Integer(int) is deprecated since version 9
		Long nine=new Long (9);
		System.out.println(ten + nine); 
		int i=1;
		System.out.println(i + ten);
		
		//OUTPUT 19 11

	}

}
