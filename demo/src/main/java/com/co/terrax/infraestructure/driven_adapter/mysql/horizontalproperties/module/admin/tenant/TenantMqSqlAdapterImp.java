package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.tenant;

import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.tenant.TenantUseCaseGateway;
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
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tenantMySqlAdapter.save(tenantEntity).getPersonId())
                .toUri();
        return ResponseEntity.created(location).build();
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
