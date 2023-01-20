package com.turtlemint.turtlemint.repository;

import com.turtlemint.turtlemint.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Integer>{
    Optional<Customer> findAllByCustomerCheckoutId(String customerCheckoutId);
    void deleteByCustomerCheckoutId(String customerCheckoutId);

}
