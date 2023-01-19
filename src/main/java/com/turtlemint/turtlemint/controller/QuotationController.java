
package com.turtlemint.turtlemint.controller;

import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.services.QuotationService;
import com.turtlemint.turtlemint.services.QuotationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/turtle")
public class QuotationController {
    @Autowired
    public QuotationService quotationService;
    @GetMapping("/quotations")
    public ResponseEntity<?> findQuotations(@RequestBody Quotation quotation){
        try {
            return new ResponseEntity<>(this.quotationService.findQuotations(quotation),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Ran into Exception", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
