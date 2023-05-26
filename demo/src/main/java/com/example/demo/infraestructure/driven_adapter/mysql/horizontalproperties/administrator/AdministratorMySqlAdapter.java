package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.administrator;

import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMySqlAdapter extends JpaRepository <AdministratorEntity, Long>{
}
