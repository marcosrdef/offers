package com.itau.api.offers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDTO {
    private String id;
    private String documentId;
    private String offer;
    private String description;
    private String date;
    private String dateLimit;
    private String status;
    private String groupOffersId;
}
