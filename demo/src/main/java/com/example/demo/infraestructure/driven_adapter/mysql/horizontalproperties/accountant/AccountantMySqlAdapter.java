package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.accountant;

import com.example.demo.domain.model.horizontalproperties.accountant.AccountantEntity;
import com.example.demo.domain.model.horizontalproperties.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantMySqlAdapter extends JpaRepository <AccountantEntity, Long>{
}
