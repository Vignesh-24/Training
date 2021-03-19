package rmiserver.utility.consignment;

import java.util.Date;

public class ConsignmentUtility implements Parcel{
	
	private int totalhr=0;
	private Date curdate=null;
	private int rem=0;
	
	@Override
	public String getDeliveryInfo(int distance, int speed, Date date) {
		this.totalhr=this.totalhours(distance, speed);
		this.curdate=date;
		String datee[]=this.getDay().toString().split(" ");
		int time=Integer.parseInt(this.getTime());
		return datee[0]+" "+datee[1]+" "+datee[2]+" Time: "+(time-1)+":30 - "+time+":00 IST";
	}

	@Override
	public int totalhours(int distance, int speed) {
		return (int)Math.ceil((float)distance/speed);
	}
	
	

	@SuppressWarnings("deprecation")
	@Override
	public Date getDay() {
		int count=this.curdate.getDay()+1;
		int num_days=0;
		int temp=this.totalhr;
		while(temp>0) {
			count=count%7;	
			
			//To handle Sat and Sun
			if(count==0 || count==6) {
				count++;
				num_days++;
				continue;
			}
			count++;num_days++;
			temp-=14;
			
		}
		return new Date(this.curdate.getTime()+(num_days*24*60*60*1000));
	}

	@Override
	public String getTime() {
		
		this.rem=this.totalhr%14;
		String msg="";
		if(this.rem!=0) {
			System.out.println(rem);
			msg=this.breakFast();
		}
		
		if(this.rem!=0) {
			System.out.println(rem);
			msg=this.lunch();
		}
		
		if(this.rem!=0) {
			System.out.println(rem);
			msg=this.dinner();
		}
		
		if(this.rem!=0) {
			System.out.println(rem);
			msg=String.valueOf(22+this.rem);
		}
		
		return msg;
	}
	
	
	//8-9AM Breakfast
	private String breakFast() {
		int cur=6;
		int rem=this.rem;
		if(this.rem<=2) {
			this.rem=0;
			return String.valueOf(cur+rem);}
		this.rem-=2;
		return null;
	}
	
	//14-16:00 Lunch
	private String lunch() {
		
		int cur=9;
		int rem=this.rem;
		if(this.rem<=5) {
			this.rem=0;
			return String.valueOf(cur+rem);}
		this.rem-=5;
		return null;
		
	}
	
	//9-10PM Dinner
	private String dinner() {
		
		int cur=16;
		int rem=this.rem;
		if(this.rem<=5) {
			this.rem=0;
			return String.valueOf(cur+rem);}
		this.rem-=5;
		return null;
	}


}
