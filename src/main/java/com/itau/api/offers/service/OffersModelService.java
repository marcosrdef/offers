package com.itau.api.offers.service;

import com.itau.api.offers.model.OffersModel;

import java.util.List;
import java.util.Optional;

public interface OffersModelService {
    Optional<OffersModel> findById(String id);
    Optional<List<OffersModel>> findByCustomerTypeElegible(String customerTypeElegible);
}
