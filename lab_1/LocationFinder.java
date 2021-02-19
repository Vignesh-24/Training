package lab_1;

public class LocationFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLocation(new int[] {2,1,9,5,7},7));
		System.out.println(findLocation(new int[] {2,1,9,5,7},0));

	}
	
	public static int findLocation(int arr[],int key) {
		
		for(int i=0;i<arr.length;i++)
			if(key==arr[i])
				return i;
		System.out.println("Element "+key+" Not Found");
		return -1;
	}

}
