package com.turtlemint.turtlemint.controller;

import com.turtlemint.turtlemint.model.Customer;
import com.turtlemint.turtlemint.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turtle")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> showAllCustomer() throws Exception{
        try {
            return new ResponseEntity<>(this.customerService.allCustomer(), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(this.customerService.allCustomer(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)throws Exception{
        if(customerService.addCustomer(customer)==true) {
            return new  ResponseEntity<>(customer, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(customer, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<?> singleCustomer(@PathVariable(value = "id") String customerId){
        try{
            Optional<Customer> customerData=this.customerService.singleCustomer(customerId);
            if(!(customerData.isPresent())){
                return new ResponseEntity<>("Result Not Found",HttpStatus.EXPECTATION_FAILED);
            }
            else{
                return new ResponseEntity<>(customerData,HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>("Result Not Found",HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable (value = "id") String customerId){
        try{
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>("Customer Deleted",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unexpected Error",HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<?> modifyCustomer(@RequestBody Customer customer, @PathVariable(value = "id") String customerId){
        try{
            boolean customerStatus=this.customerService.modifyCustomer(customerId,customer);
            if(customerStatus==false){
                return new ResponseEntity<>("No data for modify",HttpStatus.EXPECTATION_FAILED);
            }
            else{
                return new ResponseEntity<>("Data Updated",HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>("No data for modify",HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
