package com.fix.mb;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.fix.service.CustomerService;
import org.springframework.dao.DataAccessException;

import com.fix.entities.Customer;


@ManagedBean(name="CustomerMB")
@RequestScoped
public class CustomerManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    //Spring Customer Service is injected...
    @ManagedProperty(value="#{CustomerService}")
    CustomerService CustomerService;
    List<Customer> CustomerList;

    private int id;
    private String name;
    private String surname;

  
    public String addCustomer() {
        try {
            Customer Customer = new Customer();
            Customer.setId(getId());
            Customer.setSurname(surname);
            Customer.setName(getSurname());
            getCustomerService().addCustomer(Customer);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

 
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }

   
    public List<Customer> getCustomerList() {
        CustomerList = new ArrayList<Customer>();
        CustomerList.addAll(getCustomerService().getCustomers());
        return CustomerList;
    }

  
    public CustomerService getCustomerService() {
        return CustomerService;
    }

 
    public void setCustomerService(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

  
    public void setCustomerList(List<Customer> CustomerList) {
        this.CustomerList = CustomerList;
    }

   
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public String getSurname() {
        return surname;
    }

 
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
