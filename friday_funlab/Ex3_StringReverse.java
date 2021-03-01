package friday_funlab;

import java.util.Scanner;

public class Ex3_StringReverse {
	
	public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Input a string: "); 
        StringBuffer sb=new StringBuffer(scanner.next());
        System.out.print("Reverse string: "+sb.reverse()); 
        System.out.print("\n"); 
        scanner.close();
    }



}
