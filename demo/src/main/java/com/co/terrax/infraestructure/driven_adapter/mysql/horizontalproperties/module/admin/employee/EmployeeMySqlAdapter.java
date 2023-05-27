package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.employee;

import com.co.terrax.domain.model.horizontalproperties.module.admin.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMySqlAdapter extends JpaRepository <EmployeeEntity, Long>{
}
