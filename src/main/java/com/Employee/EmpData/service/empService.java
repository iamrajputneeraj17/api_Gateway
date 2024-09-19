package com.Employee.EmpData.service;

import com.Employee.EmpData.entity.Employee;
import com.Employee.EmpData.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class empService {
    @Autowired
    private EmpRepository repo;

    public empService(EmpRepository repo) {
        this.repo = repo;
    }

    public Employee createEmp(Employee emp)
    {
        return repo.save(emp);
    }

    public List<Employee> getAllEmp()
    {
        return repo.findall();
    }

    public List<Employee> getByName(String name)
    {
        List<Employee> byName = repo.findByNameNative(name);
        return byName;
    }

    public Employee update(Employee emp, Integer id)
    {
        Employee em = repo.findById(id).orElseThrow();
        em.setName(emp.getName());
        em.setCompany(emp.getCompany());
        em.setAddress(emp.getAddress());
        return repo.save(em);


    }

    public Employee getById(Integer id)
    {
        Optional<Employee> user = repo.findById(id);
        return user.orElse(null);
    }
}
