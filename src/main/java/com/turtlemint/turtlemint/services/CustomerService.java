package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Customer;
import com.turtlemint.turtlemint.model.Profile;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> allCustomer();

    boolean addCustomer(Customer customer);

    Optional<Customer> singleCustomer(String customerCheckoutId);

    boolean modifyCustomer(String customerCheckoutId, Customer customer);

    boolean deleteCustomer(String customerCheckoutId);
}
