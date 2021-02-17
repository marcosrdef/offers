package com.itau.api.offers.service;

import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.mock.OffersMock;
import com.itau.api.offers.service.impl.ConsumerOffersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public class ConsumerOffersServiceImplTest {

    @Mock
    private Logger logger = LoggerFactory.getLogger(ConsumerOffersServiceImpl.class);

    @Mock
    private OffersService offersService;

    @Mock
    private OffersFactory offersFactory;

    @InjectMocks
    private ConsumerOffersServiceImpl ConsumerOffersServiceImpl;

    @Test
    void TestConsumerOffersCustomer() throws Exception {
        String key = "701e8636-7cad-4569-9816-7228db6bdf96";
        int offset = 0;
        int partition = 0;
        String topic = "listarProdutos";
        long ts = System.currentTimeMillis();
        ConsumerOffersServiceImpl.consumerOffersCustomer(
                OffersMock.getMessageConsumer(),offset, key, partition, topic, ts);
    }


}
