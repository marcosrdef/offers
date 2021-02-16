package com.itau.api.offers.repository;

import com.itau.api.offers.model.OffersCustomerModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface OffersCustomerModelRepository extends CrudRepository<OffersCustomerModel, String> {
    Optional<List<OffersCustomerModel>> findGroupOffersId(String groupOffersId);
    Optional<List<OffersCustomerModel>> findByDocumentId(String documentId);
    Optional<OffersCustomerModel> findById(String id);
}