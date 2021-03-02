package lab_book_4;

public class Q6_DerivedBaseCons {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		

}

}
class BaseClass{
	public BaseClass() {
	//	throw new MyException();
		
	}
}

class DerivedClass extends BaseClass{
	public DerivedClass() {
	
		/*
		 * Derived class CANNOT HANDLE EXCEPTION THROWN BY BASE CLASS SINCE super() should first statement in the constructor
		 */
		
		try {
			//super();
			System.out.println("Derived class constructor..");
			throw new MyException();
		
		}
		catch (MyException e) {
			// TODO: handle exception
		}
	}
}