package lab_book_4;

public class MyExceptionDemo{
	public static void main(String[] args) {
		
		try {
			System.out.println("Going to throw MyException..");
			throw new MyException();
		}	
		catch(MyException my) {
			System.out.println("exception handling..!");
		}
	}
}


class MyException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		System.out.println("MyException created..");

	}

}

