package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.accountant;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.co.terrax.domain.model.horizontalproperties.accountant.AccountantReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.accountant.AccountantUseCase;
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
    @SuppressWarnings("unused")
    public List<AccountantEntity> getAllAccountant(){
        return accountantUseCase.getAllAccountant();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<AccountantReponseSuccessEntity> getByIdAccountant(@PathVariable Long id){
        return accountantUseCase.getByIdAccountant(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createAccountant(@RequestBody AccountantEntity accountantEntity){
        return accountantUseCase.createAccountant(accountantEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteAccountant(@PathVariable Long id){
        return accountantUseCase.deleteAccountantById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody AccountantEntity accountantEntity){
        return accountantUseCase.updateAccountantById(id, accountantEntity);
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






