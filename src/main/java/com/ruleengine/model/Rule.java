package com.ruleengine.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class Rule {

    @Id
    private String id; // Unique identifier
    private String ruleString; // The actual rule string

    public Rule(String ruleString) {
        this.ruleString = ruleString;
    }

    public Rule() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    @Override
    public String toString() {
        return ruleString;
    }
}
