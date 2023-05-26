package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.property;

import com.example.demo.domain.model.horizontalproperties.property.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyMySqlAdapter extends JpaRepository <PropertyEntity, Long>{
}
