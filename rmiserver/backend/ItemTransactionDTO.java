package rmiserver.backend;

import java.io.Serializable;

public class ItemTransactionDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	public ItemTransactionDTO(int invno, int itemno, int itemunit) {
		this.invno = invno;
		this.itemno = itemno;
		this.itemunit = itemunit;
	}
	
	public ItemTransactionDTO() {
		// TODO Auto-generated constructor stub
	}
   

	private int invno;
	private int itemno;
	private int itemunit;
	
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public int getItemunit() {
		return itemunit;
	}
	public void setItemunit(int itemunit) {
		this.itemunit = itemunit;
	}
	
	
	@Override
	public String toString() {
		return "ItemTransactionDTO [invno=" + invno + ", itemno=" + itemno + ", itemunit=" + itemunit + "]";
	}
	
	

}
