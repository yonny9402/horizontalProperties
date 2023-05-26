package com.co.horizontalproperty.infraestructure.entry_point.rest.horizaontalproperties.administrator;

import com.co.horizontalproperty.domain.model.commons.ResponseExeptionEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.administrator.AdministratorEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.administrator.AdministratorReponseSuccessEntity;
import com.co.horizontalproperty.domain.usecase.horizontalproperties.usecase.administrator.AdministratorUseCase;
import com.co.horizontalproperty.utils.Constants;
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
    public List<AdministratorEntity> getAllAdministrator(){
        List<AdministratorEntity> listAdministrator = administratorUseCase.getAllAdministrator();
        return listAdministrator;
    }


    @GetMapping("/{id}")
    public ResponseEntity<AdministratorReponseSuccessEntity> getByIdAdministrator(@PathVariable Long id){
        return administratorUseCase.getByIdAdministrator(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createAdministrator(@RequestBody AdministratorEntity administratorEntity){
        return administratorUseCase.createAdministrator(administratorEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id){
        return administratorUseCase.deleteAdministratorById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody AdministratorEntity administratorEntity){
        return administratorUseCase.updateAdministratorById(id, administratorEntity);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(Constants.SERVER_INTERNAL_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}






