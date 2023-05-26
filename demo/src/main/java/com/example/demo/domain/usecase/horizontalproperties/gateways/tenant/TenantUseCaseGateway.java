package com.example.demo.domain.usecase.horizontalproperties.gateways.tenant;

import com.example.demo.domain.model.horizontalproperties.tenant.TenantEntity;
import com.example.demo.domain.model.horizontalproperties.tenant.TenantReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TenantUseCaseGateway {

    List<TenantEntity> getAllTenant();
    ResponseEntity<TenantReponseSuccessEntity> getTenantById(Long id);
    ResponseEntity<Void> createTenant(TenantEntity tenantEntity);
    ResponseEntity<Void> deleteTenantById(Long id);
    ResponseEntity<Void> updateTenantById(Long id, TenantEntity updateTenantEntity);
}