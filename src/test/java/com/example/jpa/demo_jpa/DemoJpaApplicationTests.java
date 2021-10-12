package com.example.jpa.demo_jpa;


import com.example.jpa.demo_jpa.repo.Employee_repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoJpaApplicationTests {

	@Test
	void contextLoads() {
	}
@Autowired
Employee_repository repository;
	@Test
	void testCreate(){
		Employee employee = new Employee();
		employee.setName("C");
		employee.setId(17);
		employee.setAge(28);
		employee.setLocation("USA");
		repository.save(employee);
	}

	@Test
	void testUpdate(){
		Employee employee =repository.findById(14).get();
		employee.setAge(26);
		repository.save(employee);
	}

	@Test
	void testDelete(){
		repository.deleteById(14);
	}

	@Test
	void testRead(){
		Employee employee =repository.findById(14).get();
		assertNotNull(employee);
		assertEquals("A",employee.getName());
	}

	@Test
	void testCount(){
		System.out.println("total record ==================="+repository.count());

	}

	@Test
	void testFindByName(){
		List<Employee> employees =repository.findByName("A");
		employees.forEach(p-> System.out.println(p.getAge()));
	}

	@Test
	void testFindByNameLike(){
		List<Employee> employees =repository.findByNameLike("A%");
		employees.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	void testFindByAgeBetween(){
		List<Employee> employees =repository.findByAgeBetween(25,32);
		employees.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	void testFindAllPagingAndSorting(){
		 Pageable pageable = PageRequest.of(0,3, Sort.Direction.DESC,"Name");
		repository.findAll(pageable).forEach(p-> System.out.println(p.getName()));
	}

}
