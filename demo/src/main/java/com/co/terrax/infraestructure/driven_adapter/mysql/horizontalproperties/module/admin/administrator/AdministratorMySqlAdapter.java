package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.administrator;

import com.co.terrax.domain.model.horizontalproperties.module.admin.administrator.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMySqlAdapter extends JpaRepository <AdministratorEntity, Long>{
}
