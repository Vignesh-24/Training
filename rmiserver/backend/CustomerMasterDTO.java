package rmiserver.backend;

import java.io.Serializable;

public class CustomerMasterDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int customerno;
	private String customername;
	private String customeraddress;
	private String customeremail;
	private long customerphone;
	
	public CustomerMasterDTO(int customerno, String customername, String customeraddress, String customeremail,
			long customerphone) {
		super();
		this.customerno = customerno;
		this.customername = customername;
		this.customeraddress = customeraddress;
		this.customeremail = customeremail;
		this.customerphone = customerphone;
	}
	
	public CustomerMasterDTO() {
		
	}
	
	
	public int getCustomerno() {
		return customerno;
	}
	public void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public long getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(long customerphone) {
		this.customerphone = customerphone;
	}
	
	

	
	@Override
	public String toString() {
		return "CustomerMasterDTO [customerno=" + customerno + ", customername=" + customername + ", customeraddress="
				+ customeraddress + ", customeremail=" + customeremail + ", customerphone=" + customerphone + "]";
	}
	
	
	
	
	
	

}
