package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.employee;

import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.employee.EmployeeUseCaseGateway;
import com.co.terrax.presentation.ResponseEntityPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class EmployeeMqSqlAdapterImp implements EmployeeUseCaseGateway {

    private final EmployeeMySqlAdapter employeeMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<EmployeeReponseSuccessEntity> getEmployeeById(Long id) {
        Optional<EmployeeEntity> getEmployee = employeeMySqlAdapter.findById(id);
        if (getEmployee.isPresent()) {
            EmployeeReponseSuccessEntity employeeResponse = responseEntityPresenter.fromEntity(getEmployee.get()).getBody();
            return ResponseEntity.ok(employeeResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createEmployee(EmployeeEntity employeeEntity) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeMySqlAdapter.save(employeeEntity).getPersonId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById(Long id) {
        Optional<EmployeeEntity> getEmployee = employeeMySqlAdapter.findById(id);
        if (getEmployee.isPresent()) {
            employeeMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateEmployeeById(Long id, EmployeeEntity updateEmployeeEntity) {
        Optional<EmployeeEntity> employeeToUpdate = employeeMySqlAdapter.findById(id);
        if (employeeToUpdate.isPresent()) {
            employeeToUpdate.get().setPersonId(employeeToUpdate.get().getPersonId());
            employeeToUpdate.get().setFirstName(updateEmployeeEntity.getFirstName());
            employeeToUpdate.get().setLastName(updateEmployeeEntity.getLastName());
            employeeToUpdate.get().setEmail(updateEmployeeEntity.getEmail());
            employeeToUpdate.get().setPhoneNumber(updateEmployeeEntity.getPhoneNumber());
            employeeToUpdate.get().setAddress(updateEmployeeEntity.getAddress());
            employeeToUpdate.get().setCity(updateEmployeeEntity.getCity());
            employeeToUpdate.get().setCountry(updateEmployeeEntity.getCountry());
            employeeToUpdate.get().setPosition(updateEmployeeEntity.getPosition());
            employeeToUpdate.get().setSalary(updateEmployeeEntity.getSalary());
            employeeToUpdate.get().setHireDate(updateEmployeeEntity.getHireDate());
            employeeToUpdate.get().setActive(updateEmployeeEntity.getActive());
            employeeToUpdate.get().setBirthDate(updateEmployeeEntity.getBirthDate());
            employeeToUpdate.get().setGender(updateEmployeeEntity.getGender());
            employeeToUpdate.get().setCreationDate(employeeToUpdate.get().getCreationDate());
            employeeToUpdate.get().setUpdateDate(updateEmployeeEntity.getUpdateDate());
            employeeMySqlAdapter.save(employeeToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
