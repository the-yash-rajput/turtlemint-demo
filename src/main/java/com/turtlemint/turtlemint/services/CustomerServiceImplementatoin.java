package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Customer;
import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementatoin implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Customer> allCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public boolean addCustomer(Customer customer){
        try {
            customerRepo.save(customer);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Customer> singleCustomer(String customerCheckoutId){
        return customerRepo.findAllByCustomerCheckoutId(customerCheckoutId);
    }
    @Override
    public boolean modifyCustomer(String customerCheckoutId, Customer customer){
        try {
            customerRepo.deleteByCustomerCheckoutId(customerCheckoutId);
            if(addCustomer(customer)==true)
                return true;
            else return false;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String customerCheckoutId){
        try {
            customerRepo.deleteByCustomerCheckoutId(customerCheckoutId);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
