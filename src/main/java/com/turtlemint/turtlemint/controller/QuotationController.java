
package com.turtlemint.turtlemint.controller;

import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.model.QuotationData;
import com.turtlemint.turtlemint.services.QuotationService;
import com.turtlemint.turtlemint.services.QuotationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turtle")
public class QuotationController {
    @Autowired
    public QuotationService quotationService;
    @GetMapping("/quotations")
    public ResponseEntity<?> findQuotations(@RequestBody Quotation quotation){
        try {
            Optional<List<QuotationData>> ansResponse=quotationService.findQuotations(quotation);
            if(ansResponse.isPresent()) {
                return new ResponseEntity<>(ansResponse, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("NO data found", HttpStatus.EXPECTATION_FAILED);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>("Ran into Exception", HttpStatus.EXPECTATION_FAILED);
        }
    }

}
