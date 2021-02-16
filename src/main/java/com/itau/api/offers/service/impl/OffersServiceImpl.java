package com.itau.api.offers.service.impl;

import com.itau.api.offers.constants.Constants;
import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.exception.NotFoundException;
import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.service.OffersCustomerModelService;
import com.itau.api.offers.service.OffersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffersServiceImpl implements OffersService {

    private final OffersCustomerModelService offersCustomerModelService;
    private final OffersFactory offersFactory;

    public OffersServiceImpl(final OffersCustomerModelService offersCustomerModelService,
                             final OffersFactory offersFactory) {
        this.offersCustomerModelService = offersCustomerModelService;
        this.offersFactory = offersFactory;
    }

    @Override
    public OffersResponseDTO offers(OffersRequestDTO offersRequest) {
        return offersFactory.convertCustomerOffersToOffersResponse(
                getOffers(offersRequest));
    }

    @Override
    public List<OffersCustomerModel> generate(OffersRequestDTO offersRequest) {
        return offersCustomerModelService.save(offersRequest);
    }

    private List<OffersCustomerModel> getOffers(OffersRequestDTO offersRequest) {
        Optional<List<OffersCustomerModel>> lstOffers = offersCustomerModelService.findGroupOffersId(offersRequest);
        if (lstOffers.isEmpty()) {
            new NotFoundException(Constants.MSG_NOT_FOUND_OFFERS);
        }
        return lstOffers.get();
    }
}
