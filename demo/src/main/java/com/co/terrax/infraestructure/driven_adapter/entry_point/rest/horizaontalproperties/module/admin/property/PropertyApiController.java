package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.module.admin.property;

import com.co.terrax.domain.model.horizontalproperties.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.property.PropertyUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/property")
@AllArgsConstructor
public class PropertyApiController {

    private final PropertyUseCase propertyUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    @SuppressWarnings("unused")
    public List<PropertyEntity> getAllProperties(){
        return propertyUseCase.getAllProperties();
    }

    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<PropertyReponseSuccessEntity> getByIdProperty(@PathVariable Long id){
        return propertyUseCase.getByIdProperty(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createProperty(@RequestBody PropertyEntity propertyEntity){
        return propertyUseCase.createProperty(propertyEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        return propertyUseCase.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody PropertyEntity propertyEntity){
        return propertyUseCase.updatePropertyById(id, propertyEntity);
    }


    @ExceptionHandler(Exception.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}
