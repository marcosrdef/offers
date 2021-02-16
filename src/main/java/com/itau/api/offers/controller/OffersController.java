package com.itau.api.offers.controller;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.service.OffersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffersController {

    private final OffersService offersService;
    private final OffersFactory offersFactory;

    public OffersController(final OffersService offersService,
                            final OffersFactory offersFactory) {
        this.offersService = offersService;
        this.offersFactory = offersFactory;
    }

    @GetMapping("/offers")
    public ResponseEntity<OffersResponseDTO> renegociation(
            @RequestBody final OffersRequestDTO effectiveRequest) {
        return ResponseEntity.ok(offersFactory.convertCustomerOffersToOffersResponse(
                offersService.offers(effectiveRequest)));
    }
}
