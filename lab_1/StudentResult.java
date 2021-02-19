package lab_1;

import java.util.Scanner;

public class StudentResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows,col;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows and columns");
		rows=sc.nextInt();
		col=sc.nextInt();
		int arr[][]=new int[rows][col];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++)
				arr[i][j]=sc.nextInt();
		}
		result(arr);
		sc.close();

	}
	
	static void result(int arr[][]) {
		System.out.println("Displaying Student Result...");
		for(int i=0;i<arr.length;i++) {
			int total=0;
			for(int j=0;j<arr[i].length;j++) {
				total+=arr[i][j];
			}
			System.out.println("Student "+(i+1)+" Total Marks : "+total);
		}
	}

}
