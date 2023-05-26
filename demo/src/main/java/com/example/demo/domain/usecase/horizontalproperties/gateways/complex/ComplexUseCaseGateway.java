package com.example.demo.domain.usecase.horizontalproperties.gateways.complex;

import com.example.demo.domain.model.horizontalproperties.complex.ComplexEntity;
import com.example.demo.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComplexUseCaseGateway {

    List<ComplexEntity> getAllComplex();
    ResponseEntity<ComplexReponseSuccessEntity> getComplexById(Long id);
    ResponseEntity<Void> createComplex(ComplexEntity ComplexEntity);
    ResponseEntity<Void> deleteComplexById(Long id);
    ResponseEntity<Void> updateComplexById(Long id, ComplexEntity updateComplexEntity);
}
