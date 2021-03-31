package model;


public class InvoiceWrapperDTO {
	
	private ItemMasterDTO item;
	private int quantity;
	
	public ItemMasterDTO getItem() {
		return item;
	}
	public void setItem(ItemMasterDTO item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	

}
