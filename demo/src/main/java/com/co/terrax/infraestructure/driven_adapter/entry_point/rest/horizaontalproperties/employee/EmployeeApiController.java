package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.employee;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.co.terrax.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.employee.EmployeeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/employee")
@AllArgsConstructor
public class EmployeeApiController {

    private final EmployeeUseCase employeeUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    @SuppressWarnings("unused")
    public List<EmployeeEntity> getAllEmployee(){
        return employeeUseCase.getAllEmployee();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<EmployeeReponseSuccessEntity> getByIdEmployee(@PathVariable Long id){
        return employeeUseCase.getByIdEmployee(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeUseCase.createEmployee(employeeEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        return employeeUseCase.deleteEmployeeById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity){
        return employeeUseCase.updateEmployeeById(id, employeeEntity);
    }

    @ExceptionHandler(Exception.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}






