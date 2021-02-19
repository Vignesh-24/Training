package lab_1;

public class ReverseHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[] {2,1,7,8,5};
		System.out.println("Before Reverse");
		for(int x:arr)
			System.out.print(x+" ");
		reverse(arr);
		System.out.println("\nAfter Reverse");
		for(int x:arr)
			System.out.print(x+" ");

	}
	
	
	static void reverse(int arr[]) {
		int left=0,right=arr.length-1,temp;
		while(left<right) {
			temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;right--;
			
		}
		
	}

}
