package com.co.terrax.domain.usecase.horizontalproperties.module.admin.gateways.complex;

import com.co.terrax.domain.model.horizontalproperties.module.admin.complex.ComplexEntity;
import com.co.terrax.domain.model.horizontalproperties.module.admin.complex.ComplexReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComplexUseCaseGateway {

    List<ComplexEntity> getAllComplex();
    ResponseEntity<ComplexReponseSuccessEntity> getComplexById(Long id);
    ResponseEntity<Void> createComplex(ComplexEntity complexEntity);
    ResponseEntity<Void> deleteComplexById(Long id);
    ResponseEntity<Void> updateComplexById(Long id, ComplexEntity updateComplexEntity);
}
