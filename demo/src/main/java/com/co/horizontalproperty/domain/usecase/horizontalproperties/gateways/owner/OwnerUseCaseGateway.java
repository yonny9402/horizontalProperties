package com.co.horizontalproperty.domain.usecase.horizontalproperties.gateways.owner;

import com.co.horizontalproperty.domain.model.horizontalproperties.owner.OwnerEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.owner.OwnerReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerUseCaseGateway {

    List<OwnerEntity> getAllOwner();
    ResponseEntity<OwnerReponseSuccessEntity> getOwnerById(Long id);
    ResponseEntity<Void> createOwner(OwnerEntity ownerEntity);
    ResponseEntity<Void> deleteOwnerById(Long id);
    ResponseEntity<Void> updateOwnerById(Long id, OwnerEntity updateOwnerEntity);
}