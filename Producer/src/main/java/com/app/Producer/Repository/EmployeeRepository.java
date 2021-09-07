package com.app.Producer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.Producer.Entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
