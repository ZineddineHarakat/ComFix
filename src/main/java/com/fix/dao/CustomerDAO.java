package com.fix.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fix.entities.Customer;


@Repository
public class CustomerDAO  {
    @Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addCustomer(Customer Customer) {
        getSessionFactory().getCurrentSession().save(Customer);
    }


    public void deleteCustomer(Customer Customer) {
        getSessionFactory().getCurrentSession().delete(Customer);
    }

    public void updateCustomer(Customer Customer) {
        getSessionFactory().getCurrentSession().update(Customer);
    }


    public Customer getCustomerById(int id) {
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from Customer  where id=?")
                                            .setParameter(0, id).list();
        return (Customer)list.get(0);
    }


    public List<Customer> getCustomers() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  Customer").list();
        return list;
    }

}
