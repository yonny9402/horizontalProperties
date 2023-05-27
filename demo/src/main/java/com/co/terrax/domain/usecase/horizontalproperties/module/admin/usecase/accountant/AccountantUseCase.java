
package com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.accountant;


import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.accountant.AccountantUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountantUseCase {

    private final AccountantUseCaseGateway accountantUseCaseGateway;

    public List<AccountantEntity> getAllAccountant(){
        return accountantUseCaseGateway.getAllAccountant();
    }

    public ResponseEntity<AccountantReponseSuccessEntity> getByIdAccountant(Long id){
        return accountantUseCaseGateway.getAccountantById(id);
    }

    public ResponseEntity<Void> createAccountant(AccountantEntity accountantEntity){
        return accountantUseCaseGateway.createAccountant(accountantEntity);
    }

    public ResponseEntity<Void> deleteAccountantById(Long id){
        return accountantUseCaseGateway.deleteAccountantById(id);

    }

    public ResponseEntity<Void> updateAccountantById(Long id, AccountantEntity updateAccountantEntity){
        return accountantUseCaseGateway.updateAccountantById(id, updateAccountantEntity);
    }
}

