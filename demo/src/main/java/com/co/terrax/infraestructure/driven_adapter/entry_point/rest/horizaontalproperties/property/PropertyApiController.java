package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.property;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.property.PropertyEntity;
import com.co.terrax.domain.model.horizontalproperties.property.PropertyReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.property.PropertyUseCase;
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
    public List<PropertyEntity> getAllProperties(){
        return propertyUseCase.getAllProperties();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PropertyReponseSuccessEntity> getByIdProperty(@PathVariable Long id){
        return propertyUseCase.getByIdProperty(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createProperty(@RequestBody PropertyEntity propertyEntity){
        return propertyUseCase.createProperty(propertyEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        return propertyUseCase.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody PropertyEntity propertyEntity){
        return propertyUseCase.updatePropertyById(id, propertyEntity);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}
