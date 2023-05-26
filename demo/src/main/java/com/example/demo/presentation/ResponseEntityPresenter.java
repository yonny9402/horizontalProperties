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
