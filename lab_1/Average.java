package lab_1;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Average avg=new Average();
		System.out.println("Average of example 1: "+ avg.getAverage(new int[] {2,3,4,5},4));
		System.out.println("Average of example 2 :"+ avg.getAverage(new int[] {7,4,21,3,4,5},6));
		System.out.println("Average of example 3 :"+ avg.getAverage(new int[] {2123,3322,4423,2500},4));
		
	}
	
	public double getAverage(int arr[],int n) {
		long sum=0;
		for(int x: arr)
			sum+=x;
		
		//just to handle divide by zero error if n is 0
		return n!=0?(double)sum/n:0;
		
	}

}
