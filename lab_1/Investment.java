package lab_1;

public class Investment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("After 3 Year : "+worth(14000));

	}
	
	public static double worth(int num) {
		double temp=(num*0.40)+num;
		System.out.println("After 1st year : "+temp);
		temp=temp-1500;
		System.out.println("After 2nd year : "+temp);
		temp=(temp*0.12)+temp;
		return temp;
	}

}
