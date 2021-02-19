package lab_1;


public class LocationAndFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLocation(new int[] {2,1,7,9,5,9,7},7);
		findLocation(new int[] {2,1,7,9,5,9,7},8);

	}
	
	public static void findLocation(int arr[],int key) {
		System.out.println("Searching for "+key);
		int count=0;
		for(int i=0;i<arr.length;i++)
			if(key==arr[i]) {
				count++;
				System.out.println("Found at index "+i);
			}
	
		if(count==0)
			System.out.println("Not Found");
		else
			System.out.println("Frequency : "+count);
				
		
	}

}
