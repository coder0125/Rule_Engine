package com.ruleengine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ruleengine.model.EvaluationData;

@Repository
public interface EvaluationDataRepository extends MongoRepository<EvaluationData, String> {
    // Custom query methods can be defined here if needed
}
