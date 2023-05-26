package com.co.horizontalproperty.infraestructure.driven_adapter.mysql.horizontalproperties.tenant;

import com.co.horizontalproperty.domain.model.horizontalproperties.tenant.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMySqlAdapter extends JpaRepository <TenantEntity, Long>{
}
