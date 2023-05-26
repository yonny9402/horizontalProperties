package com.co.horizontalproperty.infraestructure.driven_adapter.mysql.horizontalproperties.property;

import com.co.horizontalproperty.domain.model.horizontalproperties.property.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyMySqlAdapter extends JpaRepository <PropertyEntity, Long>{
}
