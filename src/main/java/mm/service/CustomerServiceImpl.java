package mm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.dao.CustomerDAO;
import mm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO; 
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> customers = customerDAO.getCustomers(); 
		
		return customers;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
	
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
	
		customerDAO.saveCustomer(customer);

	}

	@Override
	@Transactional
	public int deleteCustomer(int id) {
		
		return customerDAO.deleteCustomer(id);

	}

}
