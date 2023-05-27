package com.co.terrax.presentation;

import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.accountant.AccountantReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.complex.ComplexEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.complex.ComplexReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.owner.OwnerReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantReponseSuccessEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeReponseSuccessEntity;
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
    private final IncomeReponseSuccessEntity incomeReponseSuccessfullEntity;

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

    @Override
    public ResponseEntity<IncomeReponseSuccessEntity> fromEntity(IncomeEntity entity) {
        incomeReponseSuccessfullEntity.setIncomeEntity(entity);
        return ResponseEntity.ok(incomeReponseSuccessfullEntity);
    }


}
