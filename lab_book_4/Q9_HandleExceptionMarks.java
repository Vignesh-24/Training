package lab_book_4;

import java.util.Scanner;

public class Q9_HandleExceptionMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		int total=0,cur=0;
		for(int i=1;i<=10;i++) {
			System.out.println("Enter marks for Student "+i+" : ");
			try {
				cur=Integer.parseInt(scan.next());
				if(cur<0)
					throw new LessThanZero();
				if(cur>100)
					throw new OutOfRange();
				total+=cur;
			}catch(NumberFormatException nf) {
				System.out.println("Please Provide Integer Only..!");
				i--;
			}catch(LessThanZero lz) {
				System.out.println("Handling....");
				i--;
			}catch(OutOfRange or) {
				System.out.println("Handling....");
				i--;
			}
		}
		scan.close();
		System.out.println("Average : "+(total/10.0));

	}

}

class LessThanZero extends Throwable{
	LessThanZero(){
		System.out.println("Marks Should be > 0");
	}
}


class OutOfRange extends Throwable{
	public OutOfRange() {
		// TODO Auto-generated constructor stub
		System.out.println("Marks Should be 0-100");
	}
}