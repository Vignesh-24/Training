package lab_book;

class Base {}  
class Sub extends Base {}
class Sub2 extends Base {}

public class CEx_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b=new Base();   
		Sub s=(Sub) b;	

	}

}

/* RUNTIMEERROR
Exception in thread "main" java.lang.ClassCastException: class lab_book.Base cannot be cast to class lab_book.Sub (lab_book.Base and lab_book.Sub are in unnamed module of loader 'app')
at lab_book.CEx_17.main(CEx_17.java:12)
*/