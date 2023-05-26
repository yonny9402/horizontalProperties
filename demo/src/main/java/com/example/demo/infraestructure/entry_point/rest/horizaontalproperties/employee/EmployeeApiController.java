package com.example.demo.infraestructure.entry_point.rest.horizaontalproperties.employee;

import com.example.demo.domain.model.commons.ResponseExeptionEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import com.example.demo.domain.usecase.horizontalproperties.usecase.employee.EmployeeUseCase;
import com.example.demo.utils.Constants;
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
    public List<EmployeeEntity> getAllEmployee(){
        List<EmployeeEntity> listEmployee = employeeUseCase.getAllEmployee();
        return listEmployee;
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeReponseSuccessEntity> getByIdEmployee(@PathVariable Long id){
        return employeeUseCase.getByIdEmployee(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeUseCase.createEmployee(employeeEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        return employeeUseCase.deleteEmployeeById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity){
        return employeeUseCase.updateEmployeeById(id, employeeEntity);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(Constants.SERVER_INTERNAL_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}






