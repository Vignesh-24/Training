package utility.parser;


import java.util.Map;
import java.util.Set;

import model.CustomerMasterDTO;
import model.InvoiceMasterDTO;
import model.ItemMasterDTO;
import model.ItemTransactionDTO;



public class InvoiceWrapper {
	
	private CustomerMasterDTO customer;
	private InvoiceMasterDTO invoice;
	private Set<ItemTransactionDTO> itemtrans;
	private Map<Integer, ItemMasterDTO> itemlist;
	
	
	
	
	public InvoiceWrapper(CustomerMasterDTO customer, InvoiceMasterDTO invoice, Set<ItemTransactionDTO> itemtrans,
			Map<Integer, ItemMasterDTO> itemlist) {
		this.customer = customer;
		this.invoice = invoice;
		this.itemtrans = itemtrans;
		this.itemlist = itemlist;
	}
	
	public InvoiceWrapper() {
		// TODO Auto-generated constructor stub
	}
	public CustomerMasterDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMasterDTO customer) {
		this.customer = customer;
	}
	public InvoiceMasterDTO getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceMasterDTO invoice) {
		this.invoice = invoice;
	}
	public Set<ItemTransactionDTO> getItemtrans() {
		return itemtrans;
	}
	public void setItemtrans(Set<ItemTransactionDTO> itemtrans) {
		this.itemtrans = itemtrans;
	}
	public Map<Integer, ItemMasterDTO> getItemlist() {
		return itemlist;
	}
	public void setItemlist(Map<Integer, ItemMasterDTO> itemlist) {
		this.itemlist = itemlist;
	}
	
	
	

}
