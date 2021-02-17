package com.itau.api.offers.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;

@ExtendWith(MockitoExtension.class)
public class DtosTest {

    @Test
    void testDtos() {
        assertThat(ErrorDTO.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
                hasValidBeanHashCode(), hasValidGettersAndSetters(), hasValidBeanToString()));
        assertThat(OfferDTO.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
                hasValidBeanHashCode(), hasValidGettersAndSetters(), hasValidBeanToString()));
        assertThat(ErrorDTO.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
                hasValidBeanHashCode(), hasValidGettersAndSetters(), hasValidBeanToString()));
        assertThat(OffersRequestDTO.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
                hasValidBeanHashCode(), hasValidGettersAndSetters(), hasValidBeanToString()));
        assertThat(OffersResponseDTO.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
                hasValidBeanHashCode(), hasValidGettersAndSetters(), hasValidBeanToString()));
    }
}
