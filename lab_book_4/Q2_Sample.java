package lab_book_4;

public class Q2_Sample {
	
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			//throw new ArithmeticException();
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("mth-2 catch called");
		}
		finally {
			System.out.println("Finally...");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q2_Sample sample=new Q2_Sample();
		sample.mth1();	

	}

}
