package com.itau.api.offers.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.model.OffersCustomerModel;

import java.util.List;

public interface OffersFactory {
    OffersRequestDTO convertStringToOffersRequest(String message) throws JsonProcessingException;
    OffersResponseDTO convertCustomerOffersToOffersResponse(List<OffersCustomerModel> offersCustomer);
}
