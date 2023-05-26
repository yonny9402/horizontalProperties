package com.co.horizontalproperty.infraestructure.driven_adapter.mysql.horizontalproperties.complex;

import com.co.horizontalproperty.domain.model.horizontalproperties.complex.ComplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexMySqlAdapter extends JpaRepository <ComplexEntity, Long>{
}
