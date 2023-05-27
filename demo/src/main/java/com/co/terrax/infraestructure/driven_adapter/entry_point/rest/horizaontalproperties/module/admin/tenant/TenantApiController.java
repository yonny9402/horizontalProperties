package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.module.admin.tenant;

import com.co.terrax.domain.model.horizontalproperties.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.admin.usecase.tenant.TenantUseCase;
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
    @SuppressWarnings("unused")
    public List<TenantEntity> getAllTenant(){
        return tenantUseCase.getAllTenant();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<TenantReponseSuccessEntity> getByIdTenant(@PathVariable Long id){
        return tenantUseCase.getByIdTenant(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createTenant(@RequestBody TenantEntity tenantEntity){
        return tenantUseCase.createTenant(tenantEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id){
        return tenantUseCase.deleteTenantById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody TenantEntity tenantEntity){
        return tenantUseCase.updateTenantById(id, tenantEntity);
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






