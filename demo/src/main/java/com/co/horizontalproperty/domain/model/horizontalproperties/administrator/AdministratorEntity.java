package com.co.horizontalproperty.domain.model.horizontalproperties.administrator;

import com.co.horizontalproperty.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("administrator")

@Data
public class AdministratorEntity extends PersonEntity {

}
