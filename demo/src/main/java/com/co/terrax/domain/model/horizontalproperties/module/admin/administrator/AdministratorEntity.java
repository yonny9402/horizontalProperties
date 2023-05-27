package com.co.terrax.domain.model.horizontalproperties.module.admin.administrator;

import com.co.terrax.domain.model.horizontalproperties.module.admin.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("administrator")
@Getter
@Setter
public class AdministratorEntity extends PersonEntity {

}
