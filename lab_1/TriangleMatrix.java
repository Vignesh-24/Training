package lab_1;

import java.util.Scanner;

public class TriangleMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows,count=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows ");
		rows=sc.nextInt();
		int arr[][]=new int[rows][rows];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<=i;j++)
				arr[i][j]=count++;
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<=i;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		sc.close();

	}

}
