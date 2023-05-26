package com.example.demo.domain.usecase.horizontalproperties.gateways.employee;

import com.example.demo.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeUseCaseGateway {

    List<EmployeeEntity> getAllEmployee();
    ResponseEntity<EmployeeReponseSuccessEntity> getEmployeeById(Long id);
    ResponseEntity<Void> createEmployee(EmployeeEntity employeeEntity);
    ResponseEntity<Void> deleteEmployeeById(Long id);
    ResponseEntity<Void> updateEmployeeById(Long id, EmployeeEntity updateEmployeeEntity);
}
