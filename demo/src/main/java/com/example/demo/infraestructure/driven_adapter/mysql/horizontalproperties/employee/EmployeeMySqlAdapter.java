package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.employee;

import com.example.demo.domain.model.horizontalproperties.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMySqlAdapter extends JpaRepository <EmployeeEntity, Long>{
}
