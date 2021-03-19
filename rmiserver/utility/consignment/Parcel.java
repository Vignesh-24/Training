package rmiserver.utility.consignment;

import java.util.Date;

public interface Parcel {
	
	public String getDeliveryInfo(int distance,int speed,Date date);
	public int totalhours(int distance,int speed);
	public Date getDay();
	public String getTime();

}
