package mm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Customer> getCustomers() {
	
		Session session = sessionFactory.getCurrentSession(); 
		
		List<Customer> customers = session.createQuery("from Customer").list(); 
		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession(); 
		
		Customer customer = session.get(Customer.class, id); 
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer); 

	}

	@Override
	public int deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:id"); 
		
		query.setParameter("id", id); 
		
		return query.executeUpdate(); 

	}

}
