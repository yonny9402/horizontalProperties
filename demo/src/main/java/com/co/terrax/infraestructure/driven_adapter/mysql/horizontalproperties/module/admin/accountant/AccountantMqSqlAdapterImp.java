package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.accountant;

import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.accountant.AccountantUseCaseGateway;
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
public class AccountantMqSqlAdapterImp implements AccountantUseCaseGateway {

    private final AccountantMySqlAdapter accountantMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<AccountantEntity> getAllAccountant() {
        return accountantMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<AccountantReponseSuccessEntity> getAccountantById(Long id) {
        Optional<AccountantEntity> getAccountant = accountantMySqlAdapter.findById(id);
        if (getAccountant.isPresent()) {
            AccountantReponseSuccessEntity accountantResponse = responseEntityPresenter.fromEntity(getAccountant.get()).getBody();
            return ResponseEntity.ok(accountantResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createAccountant(AccountantEntity accountantEntity) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accountantMySqlAdapter.save(accountantEntity).getPersonId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteAccountantById(Long id) {
        Optional<AccountantEntity> getAccountant = accountantMySqlAdapter.findById(id);
        if (getAccountant.isPresent()) {
            accountantMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateAccountantById(Long id, AccountantEntity updateAccountantEntity) {
        Optional<AccountantEntity> accountantToUpdate = accountantMySqlAdapter.findById(id);
        if (accountantToUpdate.isPresent()) {
            accountantToUpdate.get().setPersonId(accountantToUpdate.get().getPersonId());
            accountantToUpdate.get().setFirstName(updateAccountantEntity.getFirstName());
            accountantToUpdate.get().setLastName(updateAccountantEntity.getLastName());
            accountantToUpdate.get().setEmail(updateAccountantEntity.getEmail());
            accountantToUpdate.get().setPhoneNumber(updateAccountantEntity.getPhoneNumber());
            accountantToUpdate.get().setAddress(updateAccountantEntity.getAddress());
            accountantToUpdate.get().setCity(updateAccountantEntity.getCity());
            accountantToUpdate.get().setCountry(updateAccountantEntity.getCountry());
            accountantToUpdate.get().setHireDate(updateAccountantEntity.getHireDate());
            accountantToUpdate.get().setActive(updateAccountantEntity.getActive());
            accountantToUpdate.get().setBirthDate(updateAccountantEntity.getBirthDate());
            accountantToUpdate.get().setGender(updateAccountantEntity.getGender());
            accountantToUpdate.get().setCreationDate(accountantToUpdate.get().getCreationDate());
            accountantToUpdate.get().setUpdateDate(updateAccountantEntity.getUpdateDate());
            accountantMySqlAdapter.save(accountantToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
