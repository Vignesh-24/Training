package lab_1;

import java.util.Scanner;

public class DaysToMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int year;
		String month="";
		year=scan.nextInt();
		month=scan.next();
		switch(month)
		{
		case "January":System.out.println("No of days is 31"); break;
		case "February":
			if(isleapyear(year))
			{
				System.out.println("No of days is 29");
			}
			else 
			{
				System.out.println("No of days is 28");
			}
			break;
		case "March":System.out.println("No of days is 31"); break;
		case "April":System.out.println("No of days is 30"); break;
		case "May":System.out.println("No of days is 31"); break;
		case "June":System.out.println("No of days is 30"); break;
		case "July":System.out.println("No of days is 31"); break;
		case "August":System.out.println("No of days is 31"); break;
		case "September":System.out.println("No of days is 30"); break;
		case "October":System.out.println("No of days is 31"); break;
		case "November":System.out.println("No of days is 30"); break;
		case "December":System.out.println("No of days is 31"); break;
		}
		scan.close();
		

	}
	
	public static boolean isleapyear(int year) {
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
					return true;
				else
				
					return false;
			}
			else
				return true;
		}
		else
			return false;
	}

}
