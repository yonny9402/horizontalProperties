package com.example.demo.domain.model.horizontalproperties.tenant;

import com.example.demo.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("tenant")

@Data
public class TenantEntity extends PersonEntity {

}
