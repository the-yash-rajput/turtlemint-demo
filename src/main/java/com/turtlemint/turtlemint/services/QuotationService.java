package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.model.QuotationData;

import java.util.List;
import java.util.Optional;

public interface QuotationService {
    Optional<List<QuotationData>> findQuotations(Quotation quotation);
}
