package lab_book;

public class Question_26_27_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=new String("Bicycle");
		int iBegin=1;
		char iEnd=3;
		System.out.println(s.substring(iBegin,iEnd));
		//OUTPUT
		//ic
		
		//27
		s="java";
		System.out.println(s.indexOf('v'));
		
		//28
		String s1=new String("Hello");
		String s2=new String("there");
		String s3=new String(); 
		s3=s1 + s2; 
		
		/*s3=s1-s2; 
		s3=s1 & s2
		s3=s1 && s2; 
		
		
		
		The operator & is undefined for the argument type(s) java.lang.String, java.lang.String
		*/

	}

}
