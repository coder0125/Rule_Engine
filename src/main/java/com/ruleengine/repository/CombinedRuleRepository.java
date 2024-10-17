package com.ruleengine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ruleengine.model.CombinedRule;

@Repository
public interface CombinedRuleRepository extends MongoRepository<CombinedRule, String> {
    // Additional query methods can be defined here if necessary
}
