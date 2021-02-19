package lab_1;

import java.util.Scanner;

public class NumberTest {
	
	 public static void main(String[] args)  {   
		  Scanner scanner=new Scanner(System.in);
		  System.out.println("Enter the number to check");
		  int n=scanner.nextInt();
		  NumberTest numberTest=new NumberTest();
		  numberTest.test(n);
		  scanner.close();
		   
	}
	 
	 
	 public void test(int num) {
		 this.ArmstrongTest(num);
		 this.PerfectTest(num);
		 this.PalindromeTest(num);
		
	}
	 
	 public void ArmstrongTest(int num) {
		 int sum=0,temp=num,res;
		 while (num>0) {
			 res=num%10;
			 num/=10;
			 sum+=(res*res*res);
			
		}
		 if(temp==sum)  
		    	System.out.println("Armstrong number");   
		 else  
		       System.out.println("Not Armstrong number");
			
	 }
	 
	 public void PerfectTest(int n) {
		 int sum=1; 
		 for(int i=2;i*i<= n;i++) 
		    { 
		        if (n%i==0) 
		        { 
		            if(i*i != n) 
		                sum=sum+i+(n/i); 
		            else
		                sum=sum+i; 
		        } 
		    }  
		    if(sum==n && n != 1) 
		        System.out.println("Perfect Number");
		    else
		    	System.out.println("Not a Perfect Number");
	 }
	 
	 
	 public void PalindromeTest(int num) {
		 
		 int temp=num;
		 int rev=0;
		 while(num>0) {
			 rev=(rev*10)+(num%10);
			 num/=10;
		 }
		 
		 if(rev==temp)
			 System.out.println("Palindrome");
		 else
			 System.out.println("Not a Paindrome");
	 }
	 

}
