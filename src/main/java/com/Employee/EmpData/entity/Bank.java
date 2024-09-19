package com.Employee.EmpData.entity;

import jakarta.persistence.*;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bankName;
    private Long amount;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee emp;

    // Constructors, getters, and setters
    public Bank() {
    }

    public Bank(Integer id, String bankName, Long amount, Employee emp) {
        this.id = id;
        this.bankName = bankName;
        this.amount = amount;
        this.emp = emp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}
