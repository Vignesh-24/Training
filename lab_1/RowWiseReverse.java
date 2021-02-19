package lab_1;

public class RowWiseReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=4,col=4;
		int[][] mat=new int[][] {{1,2,3,5},{4,5,6,1},{7,9,2,1},{1,2,3,4}};
		int[][] reversemat=new int[row][col];
		int i,j;
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				reversemat[i][j]=mat[i][col-j-1];
			}
		}
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				System.out.print(reversemat[i][j]+" ");
			}
			System.out.println();
		}

	}

}
