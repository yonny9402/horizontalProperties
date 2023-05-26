package com.co.horizontalproperty.domain.usecase.horizontalproperties.usecase.employee;


import com.co.horizontalproperty.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import com.co.horizontalproperty.domain.usecase.horizontalproperties.gateways.employee.EmployeeUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeUseCase {

    private final EmployeeUseCaseGateway employeeUseCaseGateway;

    public List<EmployeeEntity> getAllEmployee(){
        return employeeUseCaseGateway.getAllEmployee();
    }

    public ResponseEntity<EmployeeReponseSuccessEntity> getByIdEmployee(Long id){
        return employeeUseCaseGateway.getEmployeeById(id);
    }

    public ResponseEntity<Void> createEmployee(EmployeeEntity employeeEntity){
        return employeeUseCaseGateway.createEmployee(employeeEntity);
    }

    public ResponseEntity<Void> deleteEmployeeById(Long id){
        return employeeUseCaseGateway.deleteEmployeeById(id);

    }

    public ResponseEntity<Void> updateEmployeeById(Long id, EmployeeEntity updateEmployeeEntity){
        return employeeUseCaseGateway.updateEmployeeById(id, updateEmployeeEntity);
    }
}

