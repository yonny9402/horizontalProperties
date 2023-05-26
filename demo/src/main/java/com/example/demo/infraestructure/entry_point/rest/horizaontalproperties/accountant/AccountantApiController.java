package com.example.demo.infraestructure.entry_point.rest.horizaontalproperties.accountant;

import com.example.demo.domain.model.commons.ResponseExeptionEntity;
import com.example.demo.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.example.demo.domain.model.horizontalproperties.accountant.AccountantReponseSuccessEntity;
import com.example.demo.domain.usecase.horizontalproperties.usecase.accountant.AccountantUseCase;
import com.example.demo.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/accountant")
@AllArgsConstructor
public class AccountantApiController {

    private final AccountantUseCase accountantUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    public List<AccountantEntity> getAllAccountant(){
        List<AccountantEntity> listAccountant = accountantUseCase.getAllAccountant();
        return listAccountant;
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountantReponseSuccessEntity> getByIdAccountant(@PathVariable Long id){
        return accountantUseCase.getByIdAccountant(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createAccountant(@RequestBody AccountantEntity accountantEntity){
        return accountantUseCase.createAccountant(accountantEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccountant(@PathVariable Long id){
        return accountantUseCase.deleteAccountantById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody AccountantEntity accountantEntity){
        return accountantUseCase.updateAccountantById(id, accountantEntity);
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






