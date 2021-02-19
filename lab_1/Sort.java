package lab_1;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort sort=new Sort();
		int arr[]=new int[] {2,1,7,8,5};
		sort.sortArray(arr, false);
		System.out.println("Ascending Order");
		for(int x:arr)
			System.out.print(x+" ");
		
		int tarr[]=new int[] {2,1,7,8,5};
		sort.sortArray(tarr, true);
		System.out.println("\nDescending Order");
		for(int x:tarr)
			System.out.print(x+" ");
		
		

	}
	
	public void sortArray(int arr[],boolean reverse) {
		int j=0,key;
		for (int i = 1; i < arr.length; i++) 
	    {  
	        key = arr[i];  
	        j = i - 1;  
	        while (j >= 0 && arr[j] > key) 
	        {  
	            arr[j + 1] = arr[j];  
	            j = j - 1;  
	        }  
	        arr[j + 1] = key;  
	    }
		
		if(reverse) {
			j=0;key=arr.length-1;
			while(j<key) {
				int temp=arr[j];
				arr[j]=arr[key];
				arr[key]=temp;
				j++;
				key--;
			}
		}
		
	}

}
