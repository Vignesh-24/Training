package lab_1;
import java.util.Arrays;
public class ResizeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int oldarr[]=new int[] {1,2,3,4,5};
		System.out.println("Old Array Size : "+oldarr.length);
		
		int newarr[]=Arrays.copyOf(oldarr,10);
		System.out.println("New Array Size : "+newarr.length);
		
		//Removing reference to old array
		oldarr=null;
		

	}

}
