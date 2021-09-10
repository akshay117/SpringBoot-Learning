package com.app.Producer.ControllerTest;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpHeaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.app.Producer.Entity.Employee;
import com.app.Producer.Repository.EmployeeRepository;

import net.minidev.json.JSONArray;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeTest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	org.springframework.http.HttpHeaders headers =  new org.springframework.http.HttpHeaders();
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@BeforeEach
	public void setup() {
		
		Employee employee1 =new Employee();
		employee1.setId(61);
		employee1.setName("Mathew");
		employee1.setSalary(45545);
		
		Employee employee2 =new Employee();
		employee2.setId(91);
		employee2.setName("Akshay");
		employee2.setSalary(89854);
		
		Employee employee3 =new Employee();
		employee3.setId(11);
		employee3.setName("Athul");
		employee3.setSalary(86558);
		
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
	}
	
	
	@Test
	public void testGetAllEmployees() throws Exception{
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/employee"),HttpMethod.GET,entity,String.class);
		
		org.json.JSONArray jsonArray = new org.json.JSONArray(response.getBody());
		
		assertEquals(200,response.getStatusCodeValue());
		assertEquals(3,jsonArray.length());
		
	}
	
    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setId(22);;
        employee.setName("LUNA");
        employee.setSalary(122567);;
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/employee"),HttpMethod.GET,entity,String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
    }
	
    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Employee employee = restTemplate.getForObject(createURLWithPort("/employee") + id, Employee.class);
        employee.setName("ghosty");
        employee.setSalary(454551);
        restTemplate.put(createURLWithPort("/employee")  + id, employee);
        Employee updatedEmployee = restTemplate.getForObject(createURLWithPort("/employee") + id, Employee.class);
        assertNotNull(updatedEmployee);
    }
    
    @Test
    public void testDeleteEmployee() {
         int id = 2;
         Employee employee = restTemplate.getForObject(createURLWithPort("/employee") + id, Employee.class);
         assertNotNull(employee);
         restTemplate.delete(createURLWithPort("/employee") + id);
         try {
              employee = restTemplate.getForObject(createURLWithPort("/employee")+ id, Employee.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
	
	
	
	
	@Test
	private String createURLWithPort(String uri) {
		
		return "http://127.0.0.1:"+ port +uri;
	}
	

}
