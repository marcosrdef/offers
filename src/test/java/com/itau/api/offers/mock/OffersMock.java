package com.itau.api.offers.mock;

import com.itau.api.offers.dto.OfferDTO;
import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class OffersMock {
    public static OffersRequestDTO getOffersRequest() {
        return OffersRequestDTO.builder()
                .groupOffersId("73e9a27a-71bd-4fae-8327-fc519468b8f2")
                .build();
    }

    public static OffersResponseDTO getOffersResponse() {
        List<OfferDTO> offers = new ArrayList<>();
        offers.add(OfferDTO.builder()
                    .id("c36fc950-b489-4f99-8d10-4a7613e407c4")
                    .documentId("12768334073")
                    .offer("cartão de crédito platinum")
                    .description("cartão de crédito platinum com R$ 15.000,00 de limite com isenção mensalidade por 3 meses")
                    .date("2021-02-17T00:36:28.478Z")
                    .dateLimit("Mon May 17 21:36:28 BRT 2021")
                    .status("1")
                    .groupOffersId("73e9a27a-71bd-4fae-8327-fc519468b8f2")
                    .build());
        return OffersResponseDTO.builder()
                .offers(offers)
                .build();
    }
}
