package com.itau.api.offers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OffersApplicationTest {

    @InjectMocks
    private OffersApplication offersApplication;

    @Test
    void testMain() {
        offersApplication.main(new String[]{});
    }
}
