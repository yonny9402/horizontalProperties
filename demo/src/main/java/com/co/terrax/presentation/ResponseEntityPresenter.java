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
import org.springframework.http.ResponseEntity;

public interface ResponseEntityPresenter{

    ResponseEntity<PropertyReponseSuccessEntity> fromEntity(PropertyEntity entity);
    ResponseEntity<ComplexReponseSuccessEntity> fromEntity(ComplexEntity entity);
    ResponseEntity<EmployeeReponseSuccessEntity> fromEntity(EmployeeEntity entity);
    ResponseEntity<AccountantReponseSuccessEntity> fromEntity(AccountantEntity entity);
    ResponseEntity<AdministratorReponseSuccessEntity> fromEntity(AdministratorEntity entity);
    ResponseEntity<OwnerReponseSuccessEntity> fromEntity(OwnerEntity entity);
    ResponseEntity<TenantReponseSuccessEntity> fromEntity(TenantEntity entity);
    ResponseEntity<IncomeReponseSuccessEntity> fromEntity(IncomeEntity entity);

}
