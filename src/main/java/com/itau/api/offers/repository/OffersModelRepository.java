package com.itau.api.offers.repository;

import com.itau.api.offers.model.OffersModel;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface OffersModelRepository extends CrudRepository<OffersModel, String> {
    Optional<OffersModel> findById(String id);
    Optional<List<OffersModel>> findByCustomerTypeElegible(String customerTypeElegible);
}
