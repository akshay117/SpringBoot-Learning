package com.demo.EmployeeConsumer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.demo.EmployeeConsumer.Model.Employee;

@Service
public class EmployeeService {
	
	
	@Value("${custom.external-api.firstapi}")
	private String firstApi;
	
	
	private RestTemplate restTemplate;

	@Autowired
	public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
	}

	public String saveEmp(Employee employee) {
		HttpEntity<Employee> entity = new HttpEntity<>(employee);
		return restTemplate.exchange(firstApi,HttpMethod.POST,entity,String.class).getBody();
	}
	
	
	public List<Employee> getEmp(){
		return restTemplate.exchange (firstApi,HttpMethod.GET,null,List.class).getBody();
	}

	
	
    public String deleteEmployee(Integer id) {
    	HttpEntity<Integer> entity = new HttpEntity<>(id);
        return restTemplate.exchange (firstApi +"?id="+id,HttpMethod.DELETE,entity,String.class).getBody();
    }
    
    public Employee updateEmployee(Employee employee) {
    	
    	HttpEntity<Employee> entity = new HttpEntity<>(employee);
    	
		return restTemplate.exchange(firstApi,HttpMethod.PUT,entity,Employee.class).getBody();
    	
    }


}




































