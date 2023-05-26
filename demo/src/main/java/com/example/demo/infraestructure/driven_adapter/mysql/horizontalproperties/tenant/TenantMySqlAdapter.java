package com.example.demo.infraestructure.driven_adapter.mysql.horizontalproperties.tenant;

import com.example.demo.domain.model.horizontalproperties.owner.OwnerEntity;
import com.example.demo.domain.model.horizontalproperties.tenant.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMySqlAdapter extends JpaRepository <TenantEntity, Long>{
}
