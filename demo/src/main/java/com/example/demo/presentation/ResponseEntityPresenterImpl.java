package com.example.demo.presentation;

import com.example.demo.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.example.demo.domain.model.horizontalproperties.accountant.AccountantReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorEntity;
import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.complex.ComplexEntity;
import com.example.demo.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.owner.OwnerEntity;
import com.example.demo.domain.model.horizontalproperties.owner.OwnerReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.property.PropertyEntity;
import com.example.demo.domain.model.horizontalproperties.property.PropertyReponseSuccessEntity;
import com.example.demo.domain.model.horizontalproperties.tenant.TenantEntity;
import com.example.demo.domain.model.horizontalproperties.tenant.TenantReponseSuccessEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ResponseEntityPresenterImpl implements ResponseEntityPresenter {

    private final PropertyReponseSuccessEntity propertyReponseSuccessfullEntity;
    private final ComplexReponseSuccessEntity complexReponseSuccessfullEntity;
    private final EmployeeReponseSuccessEntity employeeReponseSuccessfullEntity;
    private final AccountantReponseSuccessEntity accountantReponseSuccesfullsEntity;
    private final AdministratorReponseSuccessEntity administratorReponseSuccessfullEntity;
    private final OwnerReponseSuccessEntity ownerReponseSuccessfullEntity;
    private final TenantReponseSuccessEntity tenantReponseSuccessfullEntity;

    @Override
    public ResponseEntity<PropertyReponseSuccessEntity> fromEntity(PropertyEntity entity) {
        propertyReponseSuccessfullEntity.setPropertyEntity(entity);
        return ResponseEntity.ok(propertyReponseSuccessfullEntity);
    }

    @Override
    public ResponseEntity<ComplexReponseSuccessEntity> fromEntity(ComplexEntity entity) {
        complexReponseSuccessfullEntity.setComplexEntity(entity);
        return ResponseEntity.ok(complexReponseSuccessfullEntity);
    }

    @Override
    public ResponseEntity<EmployeeReponseSuccessEntity> fromEntity(EmployeeEntity entity) {
        employeeReponseSuccessfullEntity.setEmployeeEntity(entity);
        return ResponseEntity.ok(employeeReponseSuccessfullEntity);
    }

    @Override
    public ResponseEntity<AccountantReponseSuccessEntity> fromEntity(AccountantEntity entity) {
        accountantReponseSuccesfullsEntity.setAccountantEntity(entity);
        return ResponseEntity.ok(accountantReponseSuccesfullsEntity);
    }

    @Override
    public ResponseEntity<AdministratorReponseSuccessEntity> fromEntity(AdministratorEntity entity) {
        administratorReponseSuccessfullEntity.setAdministratorEntity(entity);
        return ResponseEntity.ok(administratorReponseSuccessfullEntity);
    }

    @Override
    public ResponseEntity<OwnerReponseSuccessEntity> fromEntity(OwnerEntity entity) {
        ownerReponseSuccessfullEntity.setOwnerEntity(entity);
        return ResponseEntity.ok(ownerReponseSuccessfullEntity);
    }

    @Override
    public ResponseEntity<TenantReponseSuccessEntity> fromEntity(TenantEntity entity) {
        tenantReponseSuccessfullEntity.setTenantEntity(entity);
        return ResponseEntity.ok(tenantReponseSuccessfullEntity);
    }


}
