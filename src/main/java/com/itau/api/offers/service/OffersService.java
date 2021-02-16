package com.itau.api.offers.service;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.model.OffersCustomerModel;

import java.util.List;

public interface OffersService {
    OffersResponseDTO offers(OffersRequestDTO offersRequest);
    List<OffersCustomerModel> generate(OffersRequestDTO offersRequest);
}
