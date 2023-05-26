package com.co.horizontalproperty.domain.model.horizontalproperties.owner;

import com.co.horizontalproperty.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("owner")

@Data
public class OwnerEntity extends PersonEntity {

}
