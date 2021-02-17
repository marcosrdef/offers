package com.itau.api.offers.controller;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.mock.OffersMock;
import com.itau.api.offers.service.OffersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OffersControllerTest {

    @InjectMocks
    private OffersController offersController;

    @Mock
    private OffersService offersService;

    @Test
    void offers() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersService.offers(request)).thenReturn(OffersMock.getOffersResponse());
        assertNotNull(offersController.offers(request));
    }
}
