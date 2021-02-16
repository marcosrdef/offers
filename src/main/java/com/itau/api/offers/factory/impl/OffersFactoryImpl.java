package com.itau.api.offers.factory.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.api.offers.dto.OfferDTO;
import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.model.OffersCustomerModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffersFactoryImpl implements OffersFactory {
    @Override
    public OffersRequestDTO convertStringToOffersRequest(String message) throws JsonProcessingException {
         return new ObjectMapper().readValue(message, OffersRequestDTO.class);
    }

    @Override
    public OffersResponseDTO convertCustomerOffersToOffersResponse(List<OffersCustomerModel> offersCustomer) {
        List<OfferDTO> lstOffers = new ArrayList<>();
        offersCustomer.forEach(offerCustomer ->{
            lstOffers.add(OfferDTO.builder()
                            .date(offerCustomer.getDate())
                            .dateLimit(offerCustomer.getDateLimit())
                            .groupOffersId(offerCustomer.getGroupOffersId())
                            .offer(offerCustomer.getOffer())
                            .description(offerCustomer.getDescription())
                            .documentId(offerCustomer.getDocumentId())
                            .id(offerCustomer.getId())
                            .status(offerCustomer.getStatus())
                            .build());
        });
        return OffersResponseDTO
                .builder()
                .offers(lstOffers)
                .build();
    }
}
