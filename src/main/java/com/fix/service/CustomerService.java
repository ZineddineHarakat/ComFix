package com.fix.service;




import java.util.List;

import com.fix.dao.CustomerDAO;
import com.fix.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerService {

    // CustomerDAO is injected...
    @Autowired
    CustomerDAO CustomerDAO;
 
    @Transactional(readOnly = false)
    public void addCustomer(Customer Customer) {
        getCustomerDAO().addCustomer(Customer);
    }

    @Transactional(readOnly = false)
    public void deleteCustomer(Customer Customer) {
        getCustomerDAO().deleteCustomer(Customer);
    }

 
    @Transactional(readOnly = false)
    public void updateCustomer(Customer Customer) {
        getCustomerDAO().updateCustomer(Customer);
    }

 

    public Customer getCustomerById(int id) {
        return getCustomerDAO().getCustomerById(id);
    }


    public List<Customer> getCustomers() {
        return getCustomerDAO().getCustomers();
    }

    public CustomerDAO getCustomerDAO() {
        return CustomerDAO;
    }

    public void setCustomerDAO(CustomerDAO CustomerDAO) {
        this.CustomerDAO = CustomerDAO;
    }
}
