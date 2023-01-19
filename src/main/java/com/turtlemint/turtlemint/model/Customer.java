package com.turtlemint.turtlemint.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection  = "turtle-customer")
public class Customer {

    @Id
    private String id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerCheckoutId;
    private String requestId;

}

