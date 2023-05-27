package com.co.terrax.domain.usecase.horizontalproperties.module.finance.usecase.income;

import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.finance.gateways.income.IncomeUseCaseGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class IncomeUseCase {

    private final IncomeUseCaseGateway incomeUseCaseGateway;

    public List<IncomeEntity> getAllIncome(){
        return incomeUseCaseGateway.getAllIncome();
    }

    public ResponseEntity<IncomeReponseSuccessEntity> getByIdIncome(Long id){
        return incomeUseCaseGateway.getIncomeById(id);
    }

    public ResponseEntity<Void> createIncome(IncomeEntity incomeEntity){
        return incomeUseCaseGateway.createIncome(incomeEntity);
    }

    public ResponseEntity<Void> deleteIncomeById(Long id){
        return incomeUseCaseGateway.deleteIncomeById(id);

    }

    public ResponseEntity<Void> updateIncomeById(Long id, IncomeEntity updateIncomeEntity){
        return incomeUseCaseGateway.updateIncomeById(id, updateIncomeEntity);
    }
}

