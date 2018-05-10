package siuyin.mvcapp.dao;

import java.util.List;

import siuyin.mvc.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> getAll();

	public void save(Customer customer);
	
	public Customer getCustomer(Integer id);
	
	public void delete(Integer id);

	
	/**
	 * 返回和name相等的记录数
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
