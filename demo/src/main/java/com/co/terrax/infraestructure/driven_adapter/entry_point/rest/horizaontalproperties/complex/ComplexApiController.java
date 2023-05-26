package com.co.terrax.infraestructure.driven_adapter.entry_point.rest.horizaontalproperties.complex;

import com.co.terrax.domain.model.commons.ResponseExeptionEntity;
import com.co.terrax.domain.model.horizontalproperties.complex.ComplexEntity;
import com.co.terrax.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.co.terrax.domain.model.usecase.horizontalproperties.usecase.complex.ComplexUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horizontal/properties/complex")
@AllArgsConstructor
public class ComplexApiController {

    private final ComplexUseCase complexUseCase;
    private final ResponseExeptionEntity responseExeptionEntity;

    @GetMapping("/queryAll")
    @SuppressWarnings("unused")
    public List<ComplexEntity> getAllComplex(){
        return complexUseCase.getAllComplex();
    }


    @GetMapping("/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<ComplexReponseSuccessEntity> getByIdComplex(@PathVariable Long id){
        return complexUseCase.getByIdComplex(id);
    }

    @PostMapping()
    @SuppressWarnings("unused")
    public ResponseEntity<Void> createComplex(@RequestBody ComplexEntity complexEntity){
        return complexUseCase.createComplex(complexEntity);
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> deleteComplex(@PathVariable Long id){
        return complexUseCase.deleteComplexById(id);
    }


    @PutMapping("/update/{id}")
    @SuppressWarnings("unused")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody ComplexEntity complexEntity){
        return complexUseCase.updateComplexById(id, complexEntity);
    }

    @ExceptionHandler(Exception.class)
    @SuppressWarnings("unused")
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}
