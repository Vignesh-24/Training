package rmiserver.backend;

import java.io.Serializable;
import java.sql.Date;


public class InvoiceMasterDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int invno;
	private Date invdate;
	private int customerno;
	
	
	
	
	public InvoiceMasterDTO(int invno, Date invdate, int customerno) {
		this.invno = invno;
		this.invdate = invdate;
		this.customerno = customerno;
	}
	
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	public int getCustomerno() {
		return customerno;
	}
	public void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	
	@Override
	public String toString() {
		return "InvoiceDTO [invno=" + invno + ", invdate=" + invdate + ", customerno=" + customerno + "]";
	}
	
	

}
