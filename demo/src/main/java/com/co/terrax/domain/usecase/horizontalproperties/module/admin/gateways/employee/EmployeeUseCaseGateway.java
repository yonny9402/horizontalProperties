package com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.employee;

import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeUseCaseGateway {

    List<EmployeeEntity> getAllEmployee();
    ResponseEntity<EmployeeReponseSuccessEntity> getEmployeeById(Long id);
    ResponseEntity<Void> createEmployee(EmployeeEntity employeeEntity);
    ResponseEntity<Void> deleteEmployeeById(Long id);
    ResponseEntity<Void> updateEmployeeById(Long id, EmployeeEntity updateEmployeeEntity);
}
