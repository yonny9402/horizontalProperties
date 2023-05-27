package com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.owner;

import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerUseCaseGateway {

    List<OwnerEntity> getAllOwner();
    ResponseEntity<OwnerReponseSuccessEntity> getOwnerById(Long id);
    ResponseEntity<Void> createOwner(OwnerEntity ownerEntity);
    ResponseEntity<Void> deleteOwnerById(Long id);
    ResponseEntity<Void> updateOwnerById(Long id, OwnerEntity updateOwnerEntity);
}