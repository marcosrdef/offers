package com.itau.api.offers.service.impl;

import com.itau.api.offers.constants.Constants;
import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.exception.NotFoundException;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.model.OffersModel;
import com.itau.api.offers.repository.OffersCustomerModelRepository;
import com.itau.api.offers.service.OffersCustomerModelService;
import com.itau.api.offers.service.OffersModelService;
import com.itau.api.offers.utils.OffersUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OffersCustomerModelServiceImpl implements OffersCustomerModelService {

    private final OffersCustomerModelRepository offersCustomerModelRepository;
    private final OffersModelService offersModelService;

    public OffersCustomerModelServiceImpl(final OffersCustomerModelRepository offersCustomerModelRepository,
                                          final OffersModelService offersModelService) {
        this.offersCustomerModelRepository = offersCustomerModelRepository;
        this.offersModelService = offersModelService;
    }

    @Override
    public Optional<List<OffersCustomerModel>> findGroupOffersId(OffersRequestDTO offersRequest) {
        return offersCustomerModelRepository.findGroupOffersId(offersRequest.getGroupOffersId());
    }

    @Override
    public Optional<List<OffersCustomerModel>> findDocumentId(OffersRequestDTO offersRequest) {
        return offersCustomerModelRepository.findGroupOffersId(offersRequest.getDocumentId());
    }

    @Override
    public Optional<OffersCustomerModel> findById(OffersRequestDTO offersRequest) {
        return offersCustomerModelRepository.findById(offersRequest.getId());
    }

    @Override
    public List<OffersCustomerModel> save(OffersRequestDTO offersRequest) {
        return saveListOffers(offersRequest,
                    getOffers(offersRequest));
    }

    private List<OffersModel> getOffers(OffersRequestDTO offersRequest) {
        Optional<List<OffersModel>> lstOffers = this.offersModelService.findByCustomerTypeElegible(offersRequest.getCustomerType());
        if(lstOffers.isEmpty()) {
            new NotFoundException(Constants.MSG_NOT_FOUND_OFFERS_CUSTOMER);
        }

        return lstOffers.get();
    }

    private List<OffersCustomerModel> saveListOffers(OffersRequestDTO offersRequest, List<OffersModel> offers) {
        List<OffersCustomerModel> lstOffers = new ArrayList<>();
        offers.forEach(offer->{
            lstOffers.add(OffersCustomerModel.builder()
            .groupOffersId(offersRequest.getGroupOffersId())
            .documentId(offersRequest.getDocumentId())
            .offer(offer.getName())
            .description(offer.getDescription())
            .dateLimit(OffersUtils.getDateDays(Constants.NINETY))
            .status(Constants.ONE)
            .build());
        });
        return (List<OffersCustomerModel>) this.offersCustomerModelRepository.saveAll(lstOffers);
    }


}
