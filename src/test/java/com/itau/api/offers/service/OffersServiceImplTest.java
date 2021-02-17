package com.itau.api.offers.service;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.dto.OffersResponseDTO;
import com.itau.api.offers.exception.NotFoundException;
import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.mock.OffersCustomerMock;
import com.itau.api.offers.mock.OffersMock;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.service.impl.OffersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class OffersServiceImplTest {

    @InjectMocks
    private OffersServiceImpl OffersServiceImpl;

    @Mock
    private OffersCustomerModelService offersCustomerModelService;

    @Mock
    private OffersFactory offersFactory;

    @Test
    void TestGenerate() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        List<OffersCustomerModel> offersCustomer = OffersCustomerMock.getOffersCustomerModel();
        Mockito.when(offersCustomerModelService.save(request))
                .thenReturn(offersCustomer);
        assertNotNull(OffersServiceImpl.generate(request));
    }

    @Test
    void TestGetOffers() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        OffersResponseDTO response = OffersMock.getOffersResponse();
        List<OffersCustomerModel> offersCustomer = OffersCustomerMock.getOffersCustomerModel();
        Mockito.when(offersCustomerModelService.findGroupOffersId(request))
                .thenReturn(Optional.of(offersCustomer));
        Mockito.when(offersFactory.convertCustomerOffersToOffersResponse(offersCustomer))
                .thenReturn(response);
        assertNotNull(OffersServiceImpl.offers(request));
    }

    @Test
    void TestGetOffersNotFound() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersCustomerModelService.findGroupOffersId(request))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () ->{
            OffersServiceImpl.offers(request);
        });
    }
}
