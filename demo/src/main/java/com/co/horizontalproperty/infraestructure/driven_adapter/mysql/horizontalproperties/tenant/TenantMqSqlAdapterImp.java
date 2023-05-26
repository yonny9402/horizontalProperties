package com.co.horizontalproperty.infraestructure.driven_adapter.mysql.horizontalproperties.tenant;

import com.co.horizontalproperty.domain.model.horizontalproperties.tenant.TenantEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.tenant.TenantReponseSuccessEntity;
import com.co.horizontalproperty.domain.usecase.horizontalproperties.gateways.tenant.TenantUseCaseGateway;
import com.co.horizontalproperty.presentation.ResponseEntityPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TenantMqSqlAdapterImp implements TenantUseCaseGateway {

    private final TenantMySqlAdapter tenantMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<TenantEntity> getAllTenant() {
        return tenantMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<TenantReponseSuccessEntity> getTenantById(Long id) {
        Optional<TenantEntity> getTenant = tenantMySqlAdapter.findById(id);
        if (getTenant.isPresent()) {
            TenantReponseSuccessEntity tenantResponse = responseEntityPresenter.fromEntity(getTenant.get()).getBody();
            return ResponseEntity.ok(tenantResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createTenant(TenantEntity tenantEntity) {
        tenantMySqlAdapter.save(tenantEntity);
        return ResponseEntity.created(null).build();
    }

    @Override
    public ResponseEntity<Void> deleteTenantById(Long id) {
        Optional<TenantEntity> getTenant = tenantMySqlAdapter.findById(id);
        if (getTenant.isPresent()) {
            tenantMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateTenantById(Long id, TenantEntity updateTenantEntity) {
        Optional<TenantEntity> tenantToUpdate = tenantMySqlAdapter.findById(id);
        if (tenantToUpdate.isPresent()) {
            tenantToUpdate.get().setPersonId(tenantToUpdate.get().getPersonId());
            tenantToUpdate.get().setFirstName(updateTenantEntity.getFirstName());
            tenantToUpdate.get().setLastName(updateTenantEntity.getLastName());
            tenantToUpdate.get().setEmail(updateTenantEntity.getEmail());
            tenantToUpdate.get().setPhoneNumber(updateTenantEntity.getPhoneNumber());
            tenantToUpdate.get().setAddress(updateTenantEntity.getAddress());
            tenantToUpdate.get().setCity(updateTenantEntity.getCity());
            tenantToUpdate.get().setCountry(updateTenantEntity.getCountry());
            tenantToUpdate.get().setHireDate(updateTenantEntity.getHireDate());
            tenantToUpdate.get().setActive(updateTenantEntity.getActive());
            tenantToUpdate.get().setBirthDate(updateTenantEntity.getBirthDate());
            tenantToUpdate.get().setGender(updateTenantEntity.getGender());
            tenantToUpdate.get().setCreationDate(tenantToUpdate.get().getCreationDate());
            tenantToUpdate.get().setUpdateDate(updateTenantEntity.getUpdateDate());
            tenantMySqlAdapter.save(tenantToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
