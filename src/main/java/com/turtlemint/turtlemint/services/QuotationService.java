package com.turtlemint.turtlemint.services;

import com.turtlemint.turtlemint.model.Profile;
import com.turtlemint.turtlemint.model.Quotation;
import com.turtlemint.turtlemint.model.QuotationData;

import java.util.List;

public interface QuotationService {
    List<QuotationData> findQuotations(Quotation quotation);
}
