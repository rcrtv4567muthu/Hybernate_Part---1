package com.example.JPa_Application.JPA_Appication;
import com.example.JPa_Application.JPA_Appication.EmployeeRepository.EmployeeRepo;
import com.example.JPa_Application.JPA_Appication.Entities.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
	@SpringBootTest
	class JpAprojectApplicationTests {

		@Autowired
		EmployeeRepo employeeRepo;

		@Test
		void contextLoads() {
		}

		@Test
		public void testcreate() {
			Employee employee0 = new Employee(1, "Muthu", "Karnataka", 22);
			Employee employee1 = new Employee(2, "Mona", "Delhi", 20);
			Employee employee2 = new Employee(3, "Sri", "Chennai", 23);
			Employee employee3 = new Employee(4, "sumathi", "Telengana", 38);

			employeeRepo.save(employee0);
			employeeRepo.save(employee1);
			employeeRepo.save(employee2);
			employeeRepo.save(employee3);

		}

		@Test
		public void testUpdate() {
			Employee employee = employeeRepo.findById(1).get();
			employee.setLocation("Banashankari");
			employeeRepo.save(employee);
		}

		@Test
		public void testDelete() {
			employeeRepo.deleteById(4);
		}

		@Test
		public void testRead() {
			Employee employee = employeeRepo.findById(1).get();
			System.out.println(">>>>>>>>>" + employee.getLocation());
		}

		@Test
		public void testCount() {
			System.out.println("Total No of Employees " + employeeRepo.count());
		}

		@Test
		public void testfindByname() {
			List<Employee> employeeList = employeeRepo.findByName("Muthu");
			employeeList.forEach(p -> System.out.println(p));
		}

		@Test
		public void testPaggingAll() {
			PageRequest    pageable = PageRequest.of(1, 2, Sort.Direction.ASC, "age");
			Page<Employee> results  = employeeRepo.findAll(pageable);
			results.forEach(e -> System.out.println(e.getName() + e.getAge()));
		}

		@Test
		public void testfindByCharater() {
			List<Employee> employeeList = employeeRepo.findByNameStartingWith('S');
			employeeList.forEach(p -> System.out.println(p));

		}

		@Test
		public void testfindNamesBetweenAge() {
			List<Employee> employeeList = employeeRepo.findByAgeBetween(22, 38);
			employeeList.forEach(p -> System.out.println(p));
		}
	}


