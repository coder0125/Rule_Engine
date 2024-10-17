package com.ruleengine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "evaluation_data")
public class EvaluationData {

    @Id
    private String id;  // Unique identifier
    private String ruleString;
    private int age;
    private String department;
    private double salary;
    private int experience;
    private boolean isEligible;

    // Constructors
    public EvaluationData() {}

    public EvaluationData(String ruleString, int age, String department, double salary, int experience, boolean isEligible) {
        this.ruleString = ruleString;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
        this.isEligible = isEligible;
    }

    // Getters and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    @Override
    public String toString() {
        return "EvaluationData{" +
                "ruleString='" + ruleString + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                ", isEligible=" + isEligible +
                '}';
    }
}
