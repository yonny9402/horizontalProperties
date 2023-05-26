package com.co.horizontalproperty.infraestructure.driven_adapter.mysql.horizontalproperties.owner;

import com.co.horizontalproperty.domain.model.horizontalproperties.owner.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMySqlAdapter extends JpaRepository <OwnerEntity, Long>{
}
