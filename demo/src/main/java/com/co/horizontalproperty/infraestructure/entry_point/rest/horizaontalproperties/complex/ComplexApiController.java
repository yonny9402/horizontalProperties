package com.co.horizontalproperty.infraestructure.entry_point.rest.horizaontalproperties.complex;

import com.co.horizontalproperty.domain.model.commons.ResponseExeptionEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.complex.ComplexEntity;
import com.co.horizontalproperty.domain.model.horizontalproperties.complex.ComplexReponseSuccessEntity;
import com.co.horizontalproperty.domain.usecase.horizontalproperties.usecase.complex.ComplexUseCase;
import com.co.horizontalproperty.utils.Constants;
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
    public List<ComplexEntity> getAllComplex(){
        List<ComplexEntity> listComplex = complexUseCase.getAllComplex();
        return listComplex;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ComplexReponseSuccessEntity> getByIdComplex(@PathVariable Long id){
        return complexUseCase.getByIdComplex(id);
    }

    @PostMapping()
    public ResponseEntity<Void> createComplex(@RequestBody ComplexEntity complexEntity){
        return complexUseCase.createComplex(complexEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComplex(@PathVariable Long id){
        return complexUseCase.deleteComplexById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateExpenseById(@PathVariable Long id, @RequestBody ComplexEntity complexEntity){
        return complexUseCase.updateComplexById(id, complexEntity);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExeptionEntity> handleException(Exception e) {
        responseExeptionEntity.setStatusHppt(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        responseExeptionEntity.setReason("Ha ocurrido un error en la aplicación: " + e.getMessage());
        responseExeptionEntity.setCodeError(Constants.SERVER_INTERNAL_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseExeptionEntity);
    }

}
