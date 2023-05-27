package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.complex;

import com.co.terrax.domain.model.horizontalproperties.module.admin.complex.ComplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexMySqlAdapter extends JpaRepository <ComplexEntity, Long>{
}
