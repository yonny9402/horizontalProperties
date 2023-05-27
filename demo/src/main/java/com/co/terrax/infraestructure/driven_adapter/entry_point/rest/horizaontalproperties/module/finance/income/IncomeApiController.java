package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.module.finance.income;

import com.co.terrax.domain.model.horizontalproperties.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.finance.usecase.income.IncomeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/income")
@AllArgsConstructor
public class IncomeApiController {

    private final IncomeUseCase incomeUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    @SuppressWarnings("unused")
    public List<IncomeEntity> getAllIncome(){
        return incomeUseCase.getAllIncome();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<IncomeReponseSuccessEntity> getByIdIncome(@PathVariable Long id){
        return incomeUseCase.getByIdIncome(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createIncome(@RequestBody IncomeEntity incomeEntity){
        return incomeUseCase.createIncome(incomeEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id){
        return incomeUseCase.deleteIncomeById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody IncomeEntity incomeEntity){
        return incomeUseCase.updateIncomeById(id, incomeEntity);
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
