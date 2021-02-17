package com.itau.api.offers.mock;

import com.itau.api.offers.model.OffersCustomerModel;

import java.util.ArrayList;
import java.util.List;

public class OffersCustomerMock {

    public static List<OffersCustomerModel> getOffersCustomerModel() {
        List<OffersCustomerModel> lstCustomerModel = new ArrayList<>();
        lstCustomerModel.add(getItemCustomerModel());
        return lstCustomerModel;
    }

    public static OffersCustomerModel getItemCustomerModel() {
        return OffersCustomerModel.builder()
                .groupOffersId("701e8636-7cad-4569-9816-7228db6bdf96")
                .id("bf65b12c-233d-4ff9-983f-8d001033a089")
                .dateLimit("Tue May 18 13:52:24 BRT 2021")
                .description("crédito pré aprovado de R$ 75.000,00 taxa 1,99% a.m")
                .date("2021-02-17T16:52:25.003Z")
                .status("1")
                .documentId("12768334073")
                .offer("financiamento auto")
                .build();
    }
}
