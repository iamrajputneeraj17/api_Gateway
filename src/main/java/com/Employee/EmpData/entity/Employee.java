package com.Employee.EmpData.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @NotNull
    private String name;

    @NotEmpty
    private String address;
    private String company;


    @OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bank bank;

    public Employee() {
    }

    public Employee(Integer empId, String name, String address, String company) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.company = company;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
