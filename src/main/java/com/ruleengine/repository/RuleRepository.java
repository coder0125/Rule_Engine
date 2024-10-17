package com.ruleengine.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ruleengine.model.Rule;

@Repository
public interface RuleRepository extends MongoRepository<Rule, String> {
    // Additional custom query methods can be defined here if needed
}
