package com.itau.api.offers.controller;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.service.OffersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffersController {

    private final OffersService offersService;

    public OffersController(final OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping("/offers")
    public ResponseEntity<OffersResponseDTO> renegociation(
            @RequestBody final OffersRequestDTO effectiveRequest) {
        return ResponseEntity.ok(offersService.offers(effectiveRequest));
    }
}
