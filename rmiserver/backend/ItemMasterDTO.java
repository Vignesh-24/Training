package rmiserver.backend;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int itemno;
	private String itemdesc;
	private float itemprice;
	private int itemqty;
	
	
	public ItemMasterDTO(int itemno, String itemdesc, float itemprice, int itemqty) {
		super();
		this.itemno = itemno;
		this.itemdesc = itemdesc;
		this.itemprice = itemprice;
		this.itemqty = itemqty;
	}
	public ItemMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public float getItemprice() {
		return itemprice;
	}
	public void setItemprice(float itemprice) {
		this.itemprice = itemprice;
	}
	public int getItemqty() {
		return itemqty;
	}
	public void setItemqty(int itemqty) {
		this.itemqty = itemqty;
	}
	
	
	@Override
	public String toString() {
		return "ItemMasterDTO [itemno=" + itemno + ", itemdesc=" + itemdesc + ", itemprice=" + itemprice + ", itemqty="
				+ itemqty + "]";
	}
	
	

}
