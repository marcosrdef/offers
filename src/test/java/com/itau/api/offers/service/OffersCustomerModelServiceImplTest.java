package com.itau.api.offers.service;

import com.itau.api.offers.dto.OffersRequestDTO;
import com.itau.api.offers.exception.NotFoundException;
import com.itau.api.offers.mock.OffersCustomerMock;
import com.itau.api.offers.mock.OffersMock;
import com.itau.api.offers.repository.OffersCustomerModelRepository;
import com.itau.api.offers.service.impl.OffersCustomerModelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class OffersCustomerModelServiceImplTest {

    @InjectMocks
    private OffersCustomerModelServiceImpl offersCustomerModelServiceImpl;

    @Mock
    private OffersCustomerModelRepository offersCustomerModelRepository;

    @Mock
    private OffersModelService offersModelService;

    @Test
    void TestFindGroupOffersId() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersCustomerModelRepository.findByGroupOffersId(request.getGroupOffersId()))
                .thenReturn(Optional.of(OffersCustomerMock.getOffersCustomerModel()));
        assertNotNull(offersCustomerModelServiceImpl.findGroupOffersId(request));
    }

    @Test
    void TestFindDocumentId() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        assertNotNull(offersCustomerModelServiceImpl.findDocumentId(request));
    }

    @Test
    void TestFindById() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        assertNotNull(offersCustomerModelServiceImpl.findById(request));
    }

    @Test
    void save() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersModelService.findByCustomerTypeElegible(request.getCustomerType()))
                .thenReturn(Optional.of(OffersMock.getListOffersModel()));
        assertNotNull(offersCustomerModelServiceImpl.save(request));
    }

    @Test
    void saveOffersNotFound() {
        OffersRequestDTO request = OffersMock.getOffersRequest();
        Mockito.when(offersModelService.findByCustomerTypeElegible(request.getCustomerType()))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () ->{
            offersCustomerModelServiceImpl.save(request);
        });
    }
}
