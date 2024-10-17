package com.ruleengine.service;

import org.springframework.stereotype.Service;
import com.ruleengine.model.Rule;
import com.ruleengine.repository.RuleRepository;

@Service
public class RuleService {

    private final RuleRepository ruleRepository; // Repository for Rule

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository; // Dependency injection for RuleRepository
    }

    public Rule createRule(String ruleString) {
        Rule createdRule = new Rule(ruleString); // Create a new Rule object
        return ruleRepository.save(createdRule); // Save the rule to MongoDB
    }

    public Rule getCreatedRule(String id) {
        return ruleRepository.findById(id).orElse(null); // Fetch rule by ID
    }
}
