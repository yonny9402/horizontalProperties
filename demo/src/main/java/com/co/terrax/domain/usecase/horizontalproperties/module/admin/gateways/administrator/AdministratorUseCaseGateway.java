package com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.administrator;

import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorUseCaseGateway {

    List<AdministratorEntity> getAllAdministrator();
    ResponseEntity<AdministratorReponseSuccessEntity> getAdministratorById(Long id);
    ResponseEntity<Void> createAdministrator(AdministratorEntity administratorEntity);
    ResponseEntity<Void> deleteAdministratorById(Long id);
    ResponseEntity<Void> updateAdministratorById(Long id, AdministratorEntity updateAdministratorEntity);
}