package com.itau.api.offers.service;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.mock.OffersMock;
import com.itau.api.offers.repository.OffersModelRepository;
import com.itau.api.offers.service.impl.OffersModelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OffersModelServiceTest {

    @InjectMocks
    private OffersModelServiceImpl offersModelServiceImpl;

    @Mock
    private OffersModelRepository offersModelRepository;

    @Test
    void TestFindById() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersModelRepository.findById(request.getId()))
                .thenReturn(Optional.of(OffersMock.getOffersModelItem()));
        assertNotNull(offersModelServiceImpl.findById(request.getId()));
    }

    @Test
    void TestFindByCustomerTypeElegible() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        assertNotNull(offersModelServiceImpl.findById(request.getCustomerType()));
    }
}
