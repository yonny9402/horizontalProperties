package com.co.terrax.domain.model.usecase.horizontalproperties.usecase.complex;

import com.co.terrax.domain.model.horizontalproperties.complex.ComplexEntity;
import com.co.terrax.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.gateways.complex.ComplexUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ComplexUseCase {

    private final ComplexUseCaseGateway complexUseCaseGateway;

    public List<ComplexEntity> getAllComplex(){
        return complexUseCaseGateway.getAllComplex();
    }

    public ResponseEntity<ComplexReponseSuccessEntity> getByIdComplex(Long id){
        return complexUseCaseGateway.getComplexById(id);
    }

    public ResponseEntity<Void> createComplex(ComplexEntity complexEntity){
        return complexUseCaseGateway.createComplex(complexEntity);
    }

    public ResponseEntity<Void> deleteComplexById(Long id){
        return complexUseCaseGateway.deleteComplexById(id);

    }

    public ResponseEntity<Void> updateComplexById(Long id, ComplexEntity updateComplexEntity){
        return complexUseCaseGateway.updateComplexById(id, updateComplexEntity);
    }
}

