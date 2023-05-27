package com.co.terrax.domain.model.horizontalproperties.module.admin.owner;

import com.co.terrax.domain.model.horizontalproperties.module.admin.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("owner")
@Getter
@Setter
public class OwnerEntity extends PersonEntity {

}
