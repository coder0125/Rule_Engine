package com.ruleengine.service;

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruleengine.model.EvaluationData;
import com.ruleengine.repository.EvaluationDataRepository;

/*import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.ruleengine.model.EvaluationData;
	import com.ruleengine.repository.EvaluationDataRepository;

	import javax.script.ScriptEngine;
	import javax.script.ScriptEngineManager;
	import javax.script.ScriptException;
	import java.util.Map;
*/
	@Service
	public class EvaluationDataServiceImpl implements EvaluationDataService {

	   @Autowired
	    private EvaluationDataRepository evaluationDataRepository;

	    @Override
	    public EvaluationData evaluateRule(String ruleString, int age, String department, double salary, int experience) {
	        // Create a data context
	        Map<String, Object> userData = Map.of(
	                "age", age,
	                "department", department,
	                "salary", salary,
	                "experience", experience
	        );

	        // Evaluate the rule string
	        boolean isEligible = evaluateRuleString(ruleString, userData);

	        // Create an EvaluationData object
	        EvaluationData evaluationData = new EvaluationData(ruleString, age, department, salary, experience, isEligible);
	        
	        // Save evaluation data to MongoDB
	        return evaluationDataRepository.save(evaluationData);
	    }

	    private boolean evaluateRuleString(String ruleString, Map<String, Object> userData) {
	        // Use a JavaScript engine for evaluating the rule string
	        ScriptEngineManager manager = new ScriptEngineManager();
	        ScriptEngine engine = manager.getEngineByName("nashorn");  // JavaScript engine

	        // Inject user data into the script engine context
	        userData.forEach(engine::put);

	        try {
	            // Evaluate the rule string using the script engine
	            return (Boolean) engine.eval(ruleString);
	        } catch (ScriptException e) {
	            // Log the exception (consider using a logger)
	            e.printStackTrace();
	            return false;  // Default to false if evaluation fails
	        }
	    }
	}

