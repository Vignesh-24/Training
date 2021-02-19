package lab_1;


public class TypeCast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=10;
		double d=20.0;
		long l=1500;
		char ch='A';
		//Boolean cannot be type casted
		boolean b=true;
		
		
		//int to other
		double d1=num;
		long l1=num;
		char ch1=(char) num;
		System.out.println("int to other : "+d1+" "+" "+l1+" "+ch1);
		
		//double to other
		long l2=(long) d;
		int i2=(int) d;
		System.out.println("double to other :  "+" "+l2+" "+i2);
		
		//long to other
		int i3=(int) l;
		char ch3=(char) l; // Not Working
		double d3=l;
		System.out.println("Long to other : "+i3+" "+ch3+" "+d3);
		
		
		

	}

}
