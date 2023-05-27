package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.module.admin.administrator;

import com.co.terrax.domain.model.horizontalproperties.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.administrator.AdministratorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/administrator")
@AllArgsConstructor
public class AdministratorApiController {

    private final AdministratorUseCase administratorUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    @SuppressWarnings("unused")
    public List<AdministratorEntity> getAllAdministrator(){
        return administratorUseCase.getAllAdministrator();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<AdministratorReponseSuccessEntity> getByIdAdministrator(@PathVariable Long id){
        return administratorUseCase.getByIdAdministrator(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createAdministrator(@RequestBody AdministratorEntity administratorEntity){
        return administratorUseCase.createAdministrator(administratorEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id){
        return administratorUseCase.deleteAdministratorById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody AdministratorEntity administratorEntity){
        return administratorUseCase.updateAdministratorById(id, administratorEntity);
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






