package lab_1;

import java.util.Scanner;

public class LargestElemInRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows,col;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows and columns");
		rows=sc.nextInt();
		col=sc.nextInt();
		System.out.println("Enter Data: ");
		int arr[][]=new int[rows][col];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++)
				arr[i][j]=sc.nextInt();
		}
		result(arr);
		sc.close();

	}
	
	public static void result(int arr[][]) {
		
		for(int i=0;i<arr.length;i++) {
			int max=0;
			for(int j=0;j<arr[i].length;j++) {
				if(max<arr[i][j])
					max=arr[i][j];
			}
			System.out.println("Maximum Element in Row "+i+" : "+max);
		}
		
	}

}
