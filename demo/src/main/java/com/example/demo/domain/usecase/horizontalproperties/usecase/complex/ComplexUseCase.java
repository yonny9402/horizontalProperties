package com.example.demo.domain.usecase.horizontalproperties.usecase.complex;

import com.example.demo.domain.model.horizontalproperties.complex.ComplexEntity;
import com.example.demo.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.example.demo.domain.usecase.horizontalproperties.gateways.complex.ComplexUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ComplexUseCase {

    private final ComplexUseCaseGateway ComplexUseCaseGateway;

    public List<ComplexEntity> getAllComplex(){
        return ComplexUseCaseGateway.getAllComplex();
    }

    public ResponseEntity<ComplexReponseSuccessEntity> getByIdComplex(Long id){
        return ComplexUseCaseGateway.getComplexById(id);
    }

    public ResponseEntity<Void> createComplex(ComplexEntity ComplexEntity){
        return ComplexUseCaseGateway.createComplex(ComplexEntity);
    }

    public ResponseEntity<Void> deleteComplexById(Long id){
        return ComplexUseCaseGateway.deleteComplexById(id);

    }

    public ResponseEntity<Void> updateComplexById(Long id, ComplexEntity updateComplexEntity){
        return ComplexUseCaseGateway.updateComplexById(id, updateComplexEntity);
    }
}

