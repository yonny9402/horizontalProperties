package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.complex;

import com.co.terrax.domain.model.horizontalproperties.complex.ComplexEntity;
import com.co.terrax.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.gateways.complex.ComplexUseCaseGateway;
import com.co.terrax.presentation.ResponseEntityPresenter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ComplexMqSqlAdapterImp implements ComplexUseCaseGateway {

    private final ComplexMySqlAdapter complexMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<ComplexEntity> getAllComplex() {
        return complexMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<ComplexReponseSuccessEntity> getComplexById(Long id) {
            Optional<ComplexEntity> getComplex = complexMySqlAdapter.findById(id);
            if (getComplex.isPresent()) {
                ComplexReponseSuccessEntity propertyResponse = responseEntityPresenter.fromEntity(getComplex.get()).getBody();
                return ResponseEntity.ok(propertyResponse);
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @Override
    public ResponseEntity<Void> createComplex(ComplexEntity complexEntity) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(complexMySqlAdapter.save(complexEntity).getComplexId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteComplexById(Long id) {
            Optional<ComplexEntity> getComplex = complexMySqlAdapter.findById(id);
            if (getComplex.isPresent()) {
                complexMySqlAdapter.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @Override
    public ResponseEntity<Void> updateComplexById(Long id, ComplexEntity updateComplexEntity) {
        Optional<ComplexEntity> complexToUpdate = complexMySqlAdapter.findById(id);
        if (complexToUpdate.isPresent()) {
            complexToUpdate.get().setComplexId(complexToUpdate.get().getComplexId());
            complexToUpdate.get().setName(updateComplexEntity.getName());
            complexToUpdate.get().setDescription(updateComplexEntity.getDescription());
            complexToUpdate.get().setCategory(updateComplexEntity.getCategory());
            complexToUpdate.get().setStatus(updateComplexEntity.getStatus());
            complexToUpdate.get().setImage(updateComplexEntity.getImage());
            complexToUpdate.get().setCreationDate(complexToUpdate.get().getCreationDate());
            complexToUpdate.get().setUpdateDate(updateComplexEntity.getUpdateDate());
            complexMySqlAdapter.save(complexToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



