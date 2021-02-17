package com.itau.api.offers.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itau.api.offers.factory.impl.OffersFactoryImpl;
import com.itau.api.offers.mock.OffersCustomerMock;
import com.itau.api.offers.mock.OffersMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OffersFactoryImplTest {

    @InjectMocks
    private OffersFactoryImpl offersFactoryImpl;

    @Test
    void TestConvertStringToOffersRequest() throws JsonProcessingException {
        assertNotNull(offersFactoryImpl.convertStringToOffersRequest(
                OffersMock.getMessageConsumer()));
    }

    @Test
    void TestConvertCustomerOffersToOffersResponse() {
        assertNotNull(offersFactoryImpl.convertCustomerOffersToOffersResponse(
                OffersCustomerMock.getOffersCustomerModel()));
    }
}
