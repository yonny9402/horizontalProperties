package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.finance.income;

import com.co.terrax.domain.model.horizontalproperties.module.finance.income.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeMySqlAdapter extends JpaRepository <IncomeEntity, Long>{
}
