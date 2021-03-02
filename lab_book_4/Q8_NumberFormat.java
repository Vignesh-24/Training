package lab_book_4;

import java.util.Scanner;

public class Q8_NumberFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int total=0,cur=0;
		for(int i=1;i<=10;i++) {
			System.out.println("Enter marks for Student "+i+" : ");
			try {
				cur=Integer.parseInt(scan.next());
				total+=cur;
			}catch(NumberFormatException nf) {
				System.out.println("Please Provide Integer Only..!");
				i--;
			}
		}
		scan.close();
		System.out.println("Average : "+(total/10.0));

	}

}
