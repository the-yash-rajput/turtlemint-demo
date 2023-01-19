package com.turtlemint.turtlemint.repository;

import com.turtlemint.turtlemint.model.DummyQuotations;
import com.turtlemint.turtlemint.model.QuotationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DummyQuotationRepo extends MongoRepository<DummyQuotations,Integer> {
    List<QuotationData> findAllByVerticalAndMakeAndModel(String vertical, String make, String model);
}
