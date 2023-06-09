package com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.property;

import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.property.PropertyUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PropertyUseCase {

    private final PropertyUseCaseGateway propertyUseCaseGateway;

    public List<PropertyEntity> getAllProperties(){
        return propertyUseCaseGateway.getAllProperties();
    }

    public ResponseEntity<PropertyReponseSuccessEntity> getByIdProperty(Long id){
        return propertyUseCaseGateway.getPropertyById(id);
    }

    public ResponseEntity<Void> createProperty(PropertyEntity propertyEntity){
        return propertyUseCaseGateway.createProperty(propertyEntity);
    }

    public ResponseEntity<Void> deleteUserById(Long id){
        return propertyUseCaseGateway.deletePropertyById(id);

    }

    public ResponseEntity<Void> updatePropertyById(Long id, PropertyEntity updatePropertyEntity){
        return propertyUseCaseGateway.updatePropertyById(id, updatePropertyEntity);
    }


}

