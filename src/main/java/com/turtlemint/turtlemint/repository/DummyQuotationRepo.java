package com.turtlemint.turtlemint.repository;

import com.turtlemint.turtlemint.model.DummyQuotations;
import com.turtlemint.turtlemint.model.QuotationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DummyQuotationRepo extends MongoRepository<DummyQuotations,Integer> {
    Optional<List<QuotationData>> findAllByVerticalAndMakeAndModel(String vertical, String make, String model);
}
