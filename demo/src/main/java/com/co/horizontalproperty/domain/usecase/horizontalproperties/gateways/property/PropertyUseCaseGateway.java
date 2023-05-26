package com.co.horizontalproperty.domain.usecase.horizontalproperties.gateways.property;

import com.co.horizontalproperty.domain.model.horizontalproperties.property.PropertyEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.property.PropertyReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyUseCaseGateway {

    List<PropertyEntity> getAllProperties();
    ResponseEntity<PropertyReponseSuccessEntity> getPropertyById(Long id);
    ResponseEntity<Void> createProperty(PropertyEntity propertyEntity);
    ResponseEntity<Void> deletePropertyById(Long id);
    ResponseEntity<Void> updatePropertyById(Long id, PropertyEntity updatePropertyEntity);
}
