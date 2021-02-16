package com.itau.api.offers.service.impl;

import com.itau.api.offers.factory.OffersFactory;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.service.ConsumerOffersService;
import com.itau.api.offers.service.OffersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerOffersServiceImpl implements ConsumerOffersService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerOffersServiceImpl.class);
    private final OffersService offersService;
    private final OffersFactory offersFactory;

    public ConsumerOffersServiceImpl(final OffersService offersService,
                                     final OffersFactory offersFactory) {
        this.offersService = offersService;
        this.offersFactory = offersFactory;
    }

    @Override
    @KafkaListener(topics = {"listarProdutos"})
    public void consumerOffersCustomer(final @Payload String message,
                                   final @Header(KafkaHeaders.OFFSET) Integer offset,
                                   final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                   final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                                   final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                   final @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts
    ) throws Exception {
        logger.info(String.format("#### -> Consumed message -> TIMESTAMP: %d\n%s\noffset: %d\nkey: %s\npartition: %d\ntopic: %s", ts, message, offset, key, partition, topic));
        List<OffersCustomerModel> lstCustomerModel = offersService.generate(offersFactory.convertStringToOffersRequest(message));
        logger.info("#### offers processed -> %s", lstCustomerModel);
    }
}
