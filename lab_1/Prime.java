package lab_1;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		for(int i=2;i*i<=number;i++) {
			if(number%i==0) {
				System.out.println("Not a Prime Number");
				sc.close();
				return;
			}
				
		}
		System.out.println("Prime Number");
		sc.close();

	}

}
