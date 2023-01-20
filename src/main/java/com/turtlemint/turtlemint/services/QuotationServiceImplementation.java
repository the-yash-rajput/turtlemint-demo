package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.DummyQuotations;
import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.model.QuotationData;
import com.turtlemint.turtlemint.repository.DummyQuotationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationServiceImplementation implements QuotationService{

    @Autowired
    private DummyQuotationRepo dummyQuotationRepo;
    @Override
    public Optional<List<QuotationData>> findQuotations(Quotation quotation) {

        //Working Manual Code..
//        List<DummyQuotations> allDummyQuotationDataRepo=dummyQuotationRepo.findAll();
//        List<QuotationData> ansResponse = null;
//        for (DummyQuotations dummyData:allDummyQuotationDataRepo) {
//            if(quotation.getVehicleModel().equals(dummyData.getModel()) && quotation.getVehicleMake().equals(dummyData.getMake())
//            && quotation.getVertical().equals(dummyData.getVertical())){
//                ansResponse=(dummyData.getSupportedInsurers());
//            }
//        }
//        return Optional.ofNullable(ansResponse);

        return dummyQuotationRepo.findAllByVerticalAndMakeAndModel(quotation.getVertical(), quotation.getVehicleMake(), quotation.getVehicleModel());
    }
}
