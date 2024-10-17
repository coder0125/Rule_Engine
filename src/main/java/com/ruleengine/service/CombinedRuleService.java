package com.ruleengine.service;

import com.ruleengine.model.CombinedRule;
import com.ruleengine.repository.CombinedRuleRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinedRuleService {
    private final CombinedRuleRepository combinedRuleRepository;

   // @Autowired
    public CombinedRuleService(CombinedRuleRepository combinedRuleRepository) {
        this.combinedRuleRepository = combinedRuleRepository;
    }

    public CombinedRule combineRules(List<String> rules) {
        String combinedRuleString = String.join(" AND ", rules);  // Combine rules with "AND"
        CombinedRule combinedRule = new CombinedRule(rules, combinedRuleString);
        return combinedRuleRepository.save(combinedRule); // Save the combined rule to MongoDB
    }

    public List<CombinedRule> getAllCombinedRules() {
        return combinedRuleRepository.findAll(); // Get all combined rules from MongoDB
    }
}
