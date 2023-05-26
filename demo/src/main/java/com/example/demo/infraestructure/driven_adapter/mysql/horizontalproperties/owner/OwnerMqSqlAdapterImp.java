package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.owner;

import com.example.demo.domain.model.horizontalproperties.owner.OwnerEntity;
import com.example.demo.domain.model.horizontalproperties.owner.OwnerReponseSuccessEntity;
import com.example.demo.domain.usecase.horizontalproperties.gateways.owner.OwnerUseCaseGateway;
import com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.owner.OwnerMySqlAdapter;
import com.example.demo.presentation.ResponseEntityPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OwnerMqSqlAdapterImp implements OwnerUseCaseGateway {

    private final OwnerMySqlAdapter ownerMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<OwnerEntity> getAllOwner() {
        return ownerMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<OwnerReponseSuccessEntity> getOwnerById(Long id) {
        Optional<OwnerEntity> getOwner = ownerMySqlAdapter.findById(id);
        if (getOwner.isPresent()) {
            OwnerReponseSuccessEntity ownerResponse = responseEntityPresenter.fromEntity(getOwner.get()).getBody();
            return ResponseEntity.ok(ownerResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createOwner(OwnerEntity ownerEntity) {
        ownerMySqlAdapter.save(ownerEntity);
        return ResponseEntity.created(null).build();
    }

    @Override
    public ResponseEntity<Void> deleteOwnerById(Long id) {
        Optional<OwnerEntity> getOwner = ownerMySqlAdapter.findById(id);
        if (getOwner.isPresent()) {
            ownerMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateOwnerById(Long id, OwnerEntity updateOwnerEntity) {
        Optional<OwnerEntity> ownerToUpdate = ownerMySqlAdapter.findById(id);
        if (ownerToUpdate.isPresent()) {
            ownerToUpdate.get().setPersonId(ownerToUpdate.get().getPersonId());
            ownerToUpdate.get().setFirstName(updateOwnerEntity.getFirstName());
            ownerToUpdate.get().setLastName(updateOwnerEntity.getLastName());
            ownerToUpdate.get().setEmail(updateOwnerEntity.getEmail());
            ownerToUpdate.get().setPhoneNumber(updateOwnerEntity.getPhoneNumber());
            ownerToUpdate.get().setAddress(updateOwnerEntity.getAddress());
            ownerToUpdate.get().setCity(updateOwnerEntity.getCity());
            ownerToUpdate.get().setCountry(updateOwnerEntity.getCountry());
            ownerToUpdate.get().setHireDate(updateOwnerEntity.getHireDate());
            ownerToUpdate.get().setActive(updateOwnerEntity.getActive());
            ownerToUpdate.get().setBirthDate(updateOwnerEntity.getBirthDate());
            ownerToUpdate.get().setGender(updateOwnerEntity.getGender());
            ownerToUpdate.get().setCreationDate(ownerToUpdate.get().getCreationDate());
            ownerToUpdate.get().setUpdateDate(updateOwnerEntity.getUpdateDate());
            ownerMySqlAdapter.save(ownerToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
