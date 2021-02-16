package com.itau.api.offers.service;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.model.OffersCustomerModel;

import java.util.List;
import java.util.Optional;

public interface OffersCustomerModelService {
    Optional<List<OffersCustomerModel>> findGroupOffersId(OffersRequestDTO offersRequest);
    Optional<List<OffersCustomerModel>> findDocumentId(OffersRequestDTO offersRequest);
    Optional<OffersCustomerModel> findById(OffersRequestDTO offersRequest);
    List<OffersCustomerModel> save(OffersRequestDTO offersRequest);
}
