package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.model.QuotationData;
import com.turtlemint.turtlemint.repository.DummyQuotationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationServiceImplementation implements QuotationService{

    public DummyQuotationRepo dummyQuotationRepo;
    @Override
    public List<QuotationData> findQuotations(Quotation quotation) {
        return dummyQuotationRepo.findAllByVerticalAndMakeAndModel(quotation.getVertical(), quotation.getVehicleMake(), quotation.getVehicleModel());
    }

}
