package mm.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mm.entity.Customer;
import mm.errorExceptions.CustomerErrorDescription;
import mm.errorExceptions.CustomerException;
import mm.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		
		Customer customer = customerService.getCustomer(id); 
		
		if (customer == null) {
			throw new CustomerException("Invalid id of Customer"); 
		}
		
		return customer;  	
	}
	
	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer) { 
		
		customer.setId(0);
		
		customerService.saveCustomer(customer);	
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
	}
	
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		int customerId = customerService.deleteCustomer(id);
		
		if (customerId < 0) {
			
			throw new CustomerException("Invalid id of Customer"); 
		}
		
		return "Deleted customer id - " + id;
	}
	
}
