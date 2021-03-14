package component.parser;

import java.util.LinkedList;
import java.util.List;

public class InvoiceWrapper {
	private Customer customer=new Customer();
	@Override
	public String toString() {
		return "InvoiceWrapper [customer=" + customer + ", items=" + items + "]";
	}

	private List<Item> items=new LinkedList<>();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void add(Item item) {
		this.items.add(item);
	}
	
	public List<Item> getItems() {
		return items;
	}
	

}
