package com.ruleengine.service;

import com.ruleengine.model.EvaluationData;

public interface EvaluationDataService {
    EvaluationData evaluateRule(String ruleString, int age, String department, double salary, int experience);
}
