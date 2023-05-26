package com.co.horizontalproperty.domain.model.horizontalproperties.tenant;

import com.co.horizontalproperty.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("tenant")

@Data
public class TenantEntity extends PersonEntity {

}
