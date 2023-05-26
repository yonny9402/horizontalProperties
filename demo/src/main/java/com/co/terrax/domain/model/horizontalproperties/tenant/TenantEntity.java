package com.co.terrax.domain.model.horizontalproperties.tenant;

import com.co.terrax.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("tenant")
@Getter
@Setter
public class TenantEntity extends PersonEntity {

}
