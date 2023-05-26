package com.co.terrax.domain.model.horizontalproperties.accountant;

import com.co.terrax.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("accountant")

@Getter
@Setter
public class AccountantEntity extends PersonEntity {

}
