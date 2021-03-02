package lab_book_4;

import java.util.Scanner;

public class Q7_Divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num,deno;
		while(true) {
			try {
				System.out.println("Enter new Entries..!");
				String temp=scan.next();
				if(temp.startsWith("q") || temp.startsWith("Q")) {scan.close();
					break;}
				num=Integer.parseInt(temp);
				deno=Integer.parseInt(scan.next());
				System.out.println("Result: "+(num/deno));
			}catch(ArithmeticException ae) {
				System.out.println("Denominator shoud not be Zero..!");
			}catch(NumberFormatException nf) {
				System.out.println("Please Provide Integer Only...");
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}

	}

}
