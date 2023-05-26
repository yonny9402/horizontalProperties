package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.owner;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.owner.OwnerEntity;
import com.co.terrax.domain.model.horizontalproperties.owner.OwnerReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.owner.OwnerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/owner")
@AllArgsConstructor
public class OwnerApiController {

    private final OwnerUseCase ownerUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    public List<OwnerEntity> getAllOwner(){
        return ownerUseCase.getAllOwner();
    }


    @GetMapping("/{id}")
    public ResponseEntity<OwnerReponseSuccessEntity> getByIdOwner(@PathVariable Long id){
        return ownerUseCase.getByIdOwner(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createOwner(@RequestBody OwnerEntity ownerEntity){
        return ownerUseCase.createOwner(ownerEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        return ownerUseCase.deleteOwnerById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody OwnerEntity ownerEntity){
        return ownerUseCase.updateOwnerById(id, ownerEntity);
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






