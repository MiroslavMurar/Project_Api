package mm.dao;

import java.util.List;

import mm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(); 
	
	public Customer getCustomer(int id); 
	
	public void saveCustomer(Customer customer); 
	
	public int deleteCustomer(int id); 
}
