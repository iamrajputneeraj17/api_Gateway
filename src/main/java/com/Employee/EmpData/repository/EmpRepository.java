package com.Employee.EmpData.repository;

import com.Employee.EmpData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
    List<Employee> findByNameNative(String name);

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> findall();

}
