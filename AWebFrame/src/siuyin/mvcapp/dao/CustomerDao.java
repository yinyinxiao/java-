package siuyin.mvcapp.dao;

import java.util.List;

import siuyin.mvc.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> getAll();

	public void save(Customer customer);
	
	public Customer getCustomer(Integer id);
	
	public void delete(Integer id);

	
	/**
	 * ���غ�name��ȵļ�¼��
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
