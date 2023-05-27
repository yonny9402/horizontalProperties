package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.property;

import com.co.terrax.domain.model.horizontalproperties.module.admin.property.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyMySqlAdapter extends JpaRepository <PropertyEntity, Long>{
}
