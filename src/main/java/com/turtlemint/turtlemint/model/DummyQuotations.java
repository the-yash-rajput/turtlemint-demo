package com.turtlemint.turtlemint.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection  = "dummy-quotations")
public class DummyQuotations {
    @Id
    private String id;
    private String vertical;
    private String make;
    private String model;
    private List<QuotationData> supportedInsurers;

}
