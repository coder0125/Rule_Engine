package com.ruleengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruleengine.model.Rule;
import com.ruleengine.service.RuleService;

@Controller
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("/create")
    public String createRuleForm(Model model) {
        model.addAttribute("rule", new Rule()); // Initialize a new Rule object
        return "create_rule"; // Ensure this matches your Thymeleaf template name
    }

    @PostMapping("/create")
    public String createRule(String ruleString, Model model) {
        Rule rule = ruleService.createRule(ruleString); // Create the rule
        model.addAttribute("rule", rule); // Add the created rule to the model
        return "create_rule"; // Return back to the create rule page
    }
}
