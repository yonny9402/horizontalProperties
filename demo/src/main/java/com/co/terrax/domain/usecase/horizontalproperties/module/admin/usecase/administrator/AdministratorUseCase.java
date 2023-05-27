
package com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.administrator;


import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.administrator.AdministratorUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AdministratorUseCase {

    private final AdministratorUseCaseGateway administratorUseCaseGateway;

    public List<AdministratorEntity> getAllAdministrator(){
        return administratorUseCaseGateway.getAllAdministrator();
    }

    public ResponseEntity<AdministratorReponseSuccessEntity> getByIdAdministrator(Long id){
        return administratorUseCaseGateway.getAdministratorById(id);
    }

    public ResponseEntity<Void> createAdministrator(AdministratorEntity administratorEntity){
        return administratorUseCaseGateway.createAdministrator(administratorEntity);
    }

    public ResponseEntity<Void> deleteAdministratorById(Long id){
        return administratorUseCaseGateway.deleteAdministratorById(id);

    }

    public ResponseEntity<Void> updateAdministratorById(Long id, AdministratorEntity updateAdministratorEntity){
        return administratorUseCaseGateway.updateAdministratorById(id, updateAdministratorEntity);
    }
}

