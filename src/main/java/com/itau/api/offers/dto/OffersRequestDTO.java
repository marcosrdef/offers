package com.itau.api.offers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffersRequestDTO {
    private String id;
    private String groupOffersId;
    private String date;
    private String message;
    private String documentId;
    private String customerType;
}
