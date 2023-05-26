package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.owner;

import com.co.terrax.domain.model.horizontalproperties.owner.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerMySqlAdapter extends JpaRepository <OwnerEntity, Long>{
}
