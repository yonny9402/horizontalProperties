package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.owner;

import com.example.demo.domain.model.horizontalproperties.administrator.AdministratorEntity;
import com.example.demo.domain.model.horizontalproperties.owner.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMySqlAdapter extends JpaRepository <OwnerEntity, Long>{
}
