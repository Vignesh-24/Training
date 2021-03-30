package model;

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
	private String img;
	private String category;
	
	public ItemMasterDTO(int itemno, String itemdesc, float itemprice, int itemqty, String img, String category) {
		super();
		this.itemno = itemno;
		this.itemdesc = itemdesc;
		this.itemprice = itemprice;
		this.itemqty = itemqty;
		this.img = img;
		this.category = category;
	}
	
	public ItemMasterDTO() {
		
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	@Override
	public String toString() {
		return "ItemMasterDTO [itemno=" + itemno + ", itemdesc=" + itemdesc + ", itemprice=" + itemprice + ", itemqty="
				+ itemqty + ", img=" + img + ", category=" + category + "]";
	}
	
	
	

}
