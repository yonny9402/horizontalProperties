package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.administrator;

import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.administrator.AdministratorUseCaseGateway;
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
public class AdministratorMqSqlAdapterImp implements AdministratorUseCaseGateway {

    private final AdministratorMySqlAdapter administratorMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<AdministratorEntity> getAllAdministrator() {
        return administratorMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<AdministratorReponseSuccessEntity> getAdministratorById(Long id) {
        Optional<AdministratorEntity> getAdministrator = administratorMySqlAdapter.findById(id);
        if (getAdministrator.isPresent()) {
            AdministratorReponseSuccessEntity administratorResponse = responseEntityPresenter.fromEntity(getAdministrator.get()).getBody();
            return ResponseEntity.ok(administratorResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createAdministrator(AdministratorEntity administratorEntity) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(administratorMySqlAdapter.save(administratorEntity).getPersonId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteAdministratorById(Long id) {
        Optional<AdministratorEntity> getAdministrator = administratorMySqlAdapter.findById(id);
        if (getAdministrator.isPresent()) {
            administratorMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateAdministratorById(Long id, AdministratorEntity updateAdministratorEntity) {
        Optional<AdministratorEntity> administratorToUpdate = administratorMySqlAdapter.findById(id);
        if (administratorToUpdate.isPresent()) {
            administratorToUpdate.get().setPersonId(administratorToUpdate.get().getPersonId());
            administratorToUpdate.get().setFirstName(updateAdministratorEntity.getFirstName());
            administratorToUpdate.get().setLastName(updateAdministratorEntity.getLastName());
            administratorToUpdate.get().setEmail(updateAdministratorEntity.getEmail());
            administratorToUpdate.get().setPhoneNumber(updateAdministratorEntity.getPhoneNumber());
            administratorToUpdate.get().setAddress(updateAdministratorEntity.getAddress());
            administratorToUpdate.get().setCity(updateAdministratorEntity.getCity());
            administratorToUpdate.get().setCountry(updateAdministratorEntity.getCountry());
            administratorToUpdate.get().setHireDate(updateAdministratorEntity.getHireDate());
            administratorToUpdate.get().setActive(updateAdministratorEntity.getActive());
            administratorToUpdate.get().setBirthDate(updateAdministratorEntity.getBirthDate());
            administratorToUpdate.get().setGender(updateAdministratorEntity.getGender());
            administratorToUpdate.get().setCreationDate(administratorToUpdate.get().getCreationDate());
            administratorToUpdate.get().setUpdateDate(updateAdministratorEntity.getUpdateDate());
            administratorMySqlAdapter.save(administratorToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
