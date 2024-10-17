package com.ruleengine.controller;

import com.ruleengine.model.CombinedRule;
import com.ruleengine.service.CombinedRuleService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CreateruleController {
    private final CombinedRuleService combinedRuleService;

    //@Autowired
    public CreateruleController(CombinedRuleService combinedRuleService) {
        this.combinedRuleService = combinedRuleService;
    }

    // Display the form for combining rules
    @GetMapping("/rules/combine")
    public String showCombineRuleForm(Model model) {
        model.addAttribute("combinedRule", new CombinedRule());
        return "combine_rules"; // Return the HTML template for combining rules
    }

    // Handle form submission to combine rules
    @PostMapping("/rules/combine")
    public String combineRules(@RequestParam("rules") String rules, Model model) {
        List<String> ruleList = Arrays.asList(rules.split(","));
        CombinedRule combinedRule = combinedRuleService.combineRules(ruleList); // Combine the rules
        model.addAttribute("combinedRule", combinedRule);
        return "combine_rules"; // Return to the combine rules page
    }
}
