package com.example.demo.domain.usecase.horizontalproperties.gateways.administrator;

import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorEntity;
import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorUseCaseGateway {

    List<AdministratorEntity> getAllAdministrator();
    ResponseEntity<AdministratorReponseSuccessEntity> getAdministratorById(Long id);
    ResponseEntity<Void> createAdministrator(AdministratorEntity administratorEntity);
    ResponseEntity<Void> deleteAdministratorById(Long id);
    ResponseEntity<Void> updateAdministratorById(Long id, AdministratorEntity updateAdministratorEntity);
}