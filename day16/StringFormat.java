package day16;

public class StringFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Integer value...:%d......%s......is....%f.... the value",200,"hello world",12.4f);
		String s=String.format("\nString:%s,Integer:%06d,Float:%.3f", "hello world",90,12.341178);
		System.out.println(s);
		System.out.printf("\n%-15s%-15s%s","Column1","Column2","Column3");
		met(1,2,3,4,45);
	}
	
	public static void met(int... i) {
		for(int ii:i) {
			System.out.println(ii);
		}
	}

}  
