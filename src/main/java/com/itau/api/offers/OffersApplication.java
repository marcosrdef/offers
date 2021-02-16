package com.itau.api.offers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OffersApplication {
    public static void main(String[] args) {
        SpringApplication.run(OffersApplication.class, args);
    }
}
