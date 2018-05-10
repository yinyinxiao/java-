package siuyin.com.mvcapp.dao.Impl;

import java.util.List;

import siuyin.mvc.domain.Customer;
import siuyin.mvcapp.dao.CustomerDao;
import siuyin.mvcapp.dao.Dao;

public class CustomerDaoJdbcImpl extends Dao<Customer> implements CustomerDao{

	@Override
	public List<Customer> getAll() {
		String sql="Select* From customers";
		return getForList(sql);
		
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		String sql="insert into customers(name,address,phone) values(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		String sql="Select id,name,phone from customers where id=?";
		
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="Delect from customers where id=?";
		update(sql, id);
		
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sqlString="Select count(id) from customers where name=?";
		return getForValue(sql, name);
	}

}
