package com.co.terrax.domain.usecase.horizontalproperties.module.finance.gateways.income;

import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeReponseSuccessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IncomeUseCaseGateway {

    List<IncomeEntity> getAllIncome();
    ResponseEntity<IncomeReponseSuccessEntity> getIncomeById(Long id);
    ResponseEntity<Void> createIncome(IncomeEntity incomeEntity);
    ResponseEntity<Void> deleteIncomeById(Long id);
    ResponseEntity<Void> updateIncomeById(Long id, IncomeEntity updateIncomeEntity);

}
