package com.example.demo.domain.usecase.horizontalproperties.gateways.accountant;

import com.example.demo.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.example.demo.domain.model.horizontalproperties.accountant.AccountantReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountantUseCaseGateway {

    List<AccountantEntity> getAllAccountant();
    ResponseEntity<AccountantReponseSuccessEntity> getAccountantById(Long id);
    ResponseEntity<Void> createAccountant(AccountantEntity accountantEntity);
    ResponseEntity<Void> deleteAccountantById(Long id);
    ResponseEntity<Void> updateAccountantById(Long id, AccountantEntity updateAccountantEntity);
}