package com.itau.api.offers.service.impl;

import com.itau.api.offers.model.OffersModel;
import com.itau.api.offers.repository.OffersModelRepository;
import com.itau.api.offers.service.OffersModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffersModelServiceImpl implements OffersModelService {

    private final OffersModelRepository offersModelRepository;

    public OffersModelServiceImpl(final OffersModelRepository offersModelRepository) {
        this.offersModelRepository = offersModelRepository;
    }

    @Override
    public Optional<OffersModel> findById(String id) {
        return offersModelRepository.findById(id);
    }

    @Override
    public Optional<List<OffersModel>> findByCustomerTypeElegible(String customerTypeElegible) {
        return offersModelRepository.findByCustomerTypeElegible(customerTypeElegible);
    }
}
