package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.tenant;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.tenant.TenantEntity;
import com.co.terrax.domain.model.horizontalproperties.tenant.TenantReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.tenant.TenantUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/tenant")
@AllArgsConstructor
public class TenantApiController {

    private final TenantUseCase tenantUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    public List<TenantEntity> getAllTenant(){
        return tenantUseCase.getAllTenant();
    }


    @GetMapping("/{id}")
    public ResponseEntity<TenantReponseSuccessEntity> getByIdTenant(@PathVariable Long id){
        return tenantUseCase.getByIdTenant(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createTenant(@RequestBody TenantEntity tenantEntity){
        return tenantUseCase.createTenant(tenantEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id){
        return tenantUseCase.deleteTenantById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody TenantEntity tenantEntity){
        return tenantUseCase.updateTenantById(id, tenantEntity);
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






