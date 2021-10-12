package com.example.jpa.demo_jpa.repo;

import com.example.jpa.demo_jpa.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface Employee_repository extends PagingAndSortingRepository<Employee,Integer> {
List<Employee> findByName(String name);
List<Employee> findByNameLike(String name);
List<Employee> findByAgeBetween(int age1 ,int age2);
}