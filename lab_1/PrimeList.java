package lab_1;

public class PrimeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Using Sieve of Eratosthenes*/
		System.out.println("Prime numbers from 1 to 100");
		int arr[]=new int[101];
		for(int i=2;i*i<=100;i++) {
			if(arr[i]==0)
				for(int p = i*i; p <= 100; p += i) 
                    arr[p] = 1; 	
		}
		
		for(int i = 2; i <= 100; i++) 
        { 
            if(arr[i] == 0) 
                System.out.print(i + " "); 
        } 
		
		

	}

}
