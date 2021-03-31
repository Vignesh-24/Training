package model;

import java.util.Set;

public interface CustomerMasterDAO {
	
	public int insertCustomer(CustomerMasterDTO cust);
	public int deleteCustomer(int customerno);
	public int updateCustomer(CustomerMasterDTO cust);
	public CustomerMasterDTO getCustomer(int customerno);
	public Set<CustomerMasterDTO> getAllCustomers();
	
}
