package com.ruleengine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "combined_rules")  // Specify the collection name in MongoDB
public class CombinedRule {
    @Id
    private String id;  // Unique identifier
    private List<String> rules;  // List of individual rules
    private String combinedRule;  // The combined rule string

    // Constructors
    public CombinedRule() {}

    public CombinedRule(List<String> rules, String combinedRule) {
        this.rules = rules;
        this.combinedRule = combinedRule;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public String getCombinedRule() {
        return combinedRule;
    }

    public void setCombinedRule(String combinedRule) {
        this.combinedRule = combinedRule;
    }

    @Override
    public String toString() {
        return "Combined Rule: " + combinedRule;
    }
}
