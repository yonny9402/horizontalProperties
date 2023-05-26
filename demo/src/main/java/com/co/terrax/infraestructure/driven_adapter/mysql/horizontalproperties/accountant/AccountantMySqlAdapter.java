package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.accountant;

import com.co.terrax.domain.model.horizontalproperties.accountant.AccountantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantMySqlAdapter extends JpaRepository <AccountantEntity, Long>{
}
