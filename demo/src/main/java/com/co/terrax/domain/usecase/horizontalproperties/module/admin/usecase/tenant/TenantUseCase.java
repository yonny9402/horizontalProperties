
package com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.tenant;


import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.tenant.TenantUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TenantUseCase {

    private final TenantUseCaseGateway tenantUseCaseGateway;

    public List<TenantEntity> getAllTenant(){
        return tenantUseCaseGateway.getAllTenant();
    }

    public ResponseEntity<TenantReponseSuccessEntity> getByIdTenant(Long id){
        return tenantUseCaseGateway.getTenantById(id);
    }

    public ResponseEntity<Void> createTenant(TenantEntity tenantEntity){
        return tenantUseCaseGateway.createTenant(tenantEntity);
    }

    public ResponseEntity<Void> deleteTenantById(Long id){
        return tenantUseCaseGateway.deleteTenantById(id);

    }

    public ResponseEntity<Void> updateTenantById(Long id, TenantEntity updateTenantEntity){
        return tenantUseCaseGateway.updateTenantById(id, updateTenantEntity);
    }
}

