package com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.accountant;

import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountantUseCaseGateway {

    List<AccountantEntity> getAllAccountant();
    ResponseEntity<AccountantReponseSuccessEntity> getAccountantById(Long id);
    ResponseEntity<Void> createAccountant(AccountantEntity accountantEntity);
    ResponseEntity<Void> deleteAccountantById(Long id);
    ResponseEntity<Void> updateAccountantById(Long id, AccountantEntity updateAccountantEntity);
}