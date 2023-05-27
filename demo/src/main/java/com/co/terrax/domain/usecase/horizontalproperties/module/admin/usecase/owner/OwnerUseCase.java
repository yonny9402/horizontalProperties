
package com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.owner;


import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.owner.OwnerUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OwnerUseCase {

    private final OwnerUseCaseGateway ownerUseCaseGateway;

    public List<OwnerEntity> getAllOwner(){
        return ownerUseCaseGateway.getAllOwner();
    }

    public ResponseEntity<OwnerReponseSuccessEntity> getByIdOwner(Long id){
        return ownerUseCaseGateway.getOwnerById(id);
    }

    public ResponseEntity<Void> createOwner(OwnerEntity ownerEntity){
        return ownerUseCaseGateway.createOwner(ownerEntity);
    }

    public ResponseEntity<Void> deleteOwnerById(Long id){
        return ownerUseCaseGateway.deleteOwnerById(id);

    }

    public ResponseEntity<Void> updateOwnerById(Long id, OwnerEntity updateOwnerEntity){
        return ownerUseCaseGateway.updateOwnerById(id, updateOwnerEntity);
    }
}

