package lab_book;

public class Question_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question_35 c=new Question_35();  
        String s=new String("ello");  
        c.amethod(s);

	}
	public void amethod(String s){  
	    char c='H';  
	  //  c+=s;  The operator += is undefined for the argument type(s) char, String
	    System.out.println(c);  
	 }  



}
