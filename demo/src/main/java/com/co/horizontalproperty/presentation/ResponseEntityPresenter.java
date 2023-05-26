package com.co.horizontalproperty.presentation;

import com.co.horizontalproperty.domain.model.horizontalproperties.property.PropertyReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.accountant.AccountantReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.administrator.AdministratorEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.administrator.AdministratorReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.complex.ComplexEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.employee.EmployeeEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.employee.EmployeeReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.owner.OwnerEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.owner.OwnerReponseSuccessEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.property.PropertyEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.tenant.TenantEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.tenant.TenantReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

public interface ResponseEntityPresenter{

    ResponseEntity<PropertyReponseSuccessEntity> fromEntity(PropertyEntity entity);
    ResponseEntity<ComplexReponseSuccessEntity> fromEntity(ComplexEntity entity);
    ResponseEntity<EmployeeReponseSuccessEntity> fromEntity(EmployeeEntity entity);
    ResponseEntity<AccountantReponseSuccessEntity> fromEntity(AccountantEntity entity);
    ResponseEntity<AdministratorReponseSuccessEntity> fromEntity(AdministratorEntity entity);
    ResponseEntity<OwnerReponseSuccessEntity> fromEntity(OwnerEntity entity);
    ResponseEntity<TenantReponseSuccessEntity> fromEntity(TenantEntity entity);

}
