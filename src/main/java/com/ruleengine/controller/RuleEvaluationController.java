package com.ruleengine.controller;

import com.ruleengine.model.EvaluationData;
import com.ruleengine.service.EvaluationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RuleEvaluationController {

    @Autowired
    private EvaluationDataService evaluationDataService;

    @GetMapping("/rules/evaluate")
    public String showEvaluationForm() {
        return "evaluate_rule";  // Return the form page
    }
    
    @PostMapping("/rules/evaluate")
    public String evaluateRule(
            @RequestParam("ruleString") String ruleString,
            @RequestParam("age") int age,
            @RequestParam("department") String department,
            @RequestParam("salary") double salary,
            @RequestParam("experience") int experience,
            Model model) {

        // Evaluate the rule using the service
        EvaluationData evaluationData = evaluationDataService.evaluateRule(ruleString, age, department, salary, experience);
        
        // Add result to the model
        model.addAttribute("result", evaluationData.isEligible() ? "Eligible" : "Not Eligible");
        
        return "evaluate_rule";  // Return the template to display the result
    }
}
