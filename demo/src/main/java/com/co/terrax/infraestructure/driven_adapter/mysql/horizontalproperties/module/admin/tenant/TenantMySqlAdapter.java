package com.co.terrax.infraestructure.driven_adapter.mysql.horizontalproperties.module.admin.tenant;

import com.co.terrax.domain.model.horizontalproperties.module.admin.tenant.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMySqlAdapter extends JpaRepository <TenantEntity, Long>{
}
