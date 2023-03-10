package com.turtlemint.turtlemint.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection  = "turtle-profiles")
public class Profile {
    @Id
    private String id;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;
    private String requestId;

}
