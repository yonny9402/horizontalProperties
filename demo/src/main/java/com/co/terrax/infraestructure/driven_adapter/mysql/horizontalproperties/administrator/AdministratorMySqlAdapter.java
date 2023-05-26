package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.administrator;

import com.co.terrax.domain.model.horizontalproperties.administrator.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMySqlAdapter extends JpaRepository <AdministratorEntity, Long>{
}
