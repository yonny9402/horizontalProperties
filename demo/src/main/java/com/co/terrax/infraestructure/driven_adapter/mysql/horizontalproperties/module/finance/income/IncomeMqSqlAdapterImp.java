package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.finance.income;

import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeReponseSuccessEntity;
import com.co.terrax.domain.usecase.horizontalproperties.module.finance.gateways.income.IncomeUseCaseGateway;
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
public class IncomeMqSqlAdapterImp implements IncomeUseCaseGateway {

    private final IncomeMySqlAdapter incomeMySqlAdapter;
    private final ResponseEntityPresenter responseEntityPresenter;


    @Override
    public List<IncomeEntity> getAllIncome() {
        return incomeMySqlAdapter.findAll();
    }

    @Override
    public ResponseEntity<IncomeReponseSuccessEntity> getIncomeById(Long id) {
        Optional<IncomeEntity> getIncome = incomeMySqlAdapter.findById(id);
        if (getIncome.isPresent()) {
            IncomeReponseSuccessEntity incomeResponse = responseEntityPresenter.fromEntity(getIncome.get()).getBody();
            return ResponseEntity.ok(incomeResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> createIncome(IncomeEntity incomeEntity) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(incomeMySqlAdapter.save(incomeEntity).getIncomeId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Void> deleteIncomeById(Long id) {
        Optional<IncomeEntity> getIncome = incomeMySqlAdapter.findById(id);
        if (getIncome.isPresent()) {
            incomeMySqlAdapter.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> updateIncomeById(Long id, IncomeEntity updateIncomeEntity) {
        Optional<IncomeEntity> incomeToUpdate = incomeMySqlAdapter.findById(id);
        if (incomeToUpdate.isPresent()) {
            incomeToUpdate.get().setIncomeId(incomeToUpdate.get().getIncomeId());
            incomeToUpdate.get().setSource(updateIncomeEntity.getSource());
            incomeToUpdate.get().setAmount(updateIncomeEntity.getAmount());
            incomeToUpdate.get().setDate(updateIncomeEntity.getDate());
            incomeToUpdate.get().setDescription(updateIncomeEntity.getDescription());
            incomeToUpdate.get().setCreationDate(incomeToUpdate.get().getCreationDate());
            incomeToUpdate.get().setUpdateDate(updateIncomeEntity.getUpdateDate());
            incomeMySqlAdapter.save(incomeToUpdate.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
