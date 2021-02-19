package lab_1;
import java.util.Scanner;

public class NumberMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows,col,count=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows and columns");
		rows=sc.nextInt();
		col=sc.nextInt();
		int arr[][]=new int[rows][col];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++)
				arr[i][j]=count++;
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		sc.close();
		
		

	}

}
