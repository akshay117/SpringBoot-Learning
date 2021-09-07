package com.app.Producer.Controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.app.Producer.Entity.Employee;
import com.app.Producer.Repository.EmployeeRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employee")
public class RestController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return "Employee Saved ";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {

        Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
        if (optEmp.isPresent()) {
            Employee existEmployee = optEmp.get();

            if (Objects.nonNull(employee.getName())) {
                existEmployee.setName(employee.getName());
            }

            if (employee.getSalary() != 0.0) {
                existEmployee.setSalary(employee.getSalary());
            }
            return employeeRepo.save(existEmployee);
        }

        throw new RuntimeException("employee id not exist");
    }

    @DeleteMapping
    public String deleteEmployee(@RequestParam Integer id) {
        employeeRepo.deleteById(id);
        return "employee deleted successfully!!";
    }
}
