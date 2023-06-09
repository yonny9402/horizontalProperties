package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.property;

import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.property.PropertyUseCaseGateway;
import com.co.terrax.presentation.ResponseEntityPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PropertyMqSqlAdapterImp implements PropertyUseCaseGateway {

    private final PropertyMySqlAdapter propertyMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<PropertyEntity> getAllProperties() {
        return propertyMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<PropertyReponseSuccessEntity> getPropertyById(Long id) {
            Optional<PropertyEntity> getProperty = propertyMySqlAdapter.findById(id);
            if (getProperty.isPresent()) {
                PropertyReponseSuccessEntity propertyResponse = responseEntityPresenter.fromEntity(getProperty.get()).getBody();
                return ResponseEntity.ok(propertyResponse);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @Override
    public ResponseEntity<Void> createProperty(PropertyEntity propertyEntity) {
         URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(propertyMySqlAdapter.save(propertyEntity).getPropertyId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deletePropertyById(Long id) {
            Optional<PropertyEntity> getProperty = propertyMySqlAdapter.findById(id);
            if (getProperty.isPresent()) {
                propertyMySqlAdapter.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @Override
    public ResponseEntity<Void> updatePropertyById(Long id, PropertyEntity updatePropertyEntity) {
        Optional<PropertyEntity> propertyToUpdate = propertyMySqlAdapter.findById(id);
        if (propertyToUpdate.isPresent()) {
            propertyToUpdate.get().setPropertyId(propertyToUpdate.get().getPropertyId());
            propertyToUpdate.get().setName(updatePropertyEntity.getName());
            propertyToUpdate.get().setDescription(updatePropertyEntity.getDescription());
            propertyToUpdate.get().setAddress(updatePropertyEntity.getAddress());
            propertyToUpdate.get().setCity(updatePropertyEntity.getCity());
            propertyToUpdate.get().setCountry(updatePropertyEntity.getCountry());
            propertyToUpdate.get().setZipCode(updatePropertyEntity.getZipCode());
            propertyToUpdate.get().setYearBuilt(updatePropertyEntity.getYearBuilt());
            propertyToUpdate.get().setUpdateDate(updatePropertyEntity.getUpdateDate());
            propertyToUpdate.get().setCreationDate(propertyToUpdate.get().getCreationDate());
            propertyToUpdate.get().setStatus(updatePropertyEntity.getStatus());
            propertyMySqlAdapter.save(propertyToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



