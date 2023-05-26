package com.co.horizontalproperty.domain.model.horizontalproperties.accountant;

import com.co.horizontalproperty.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("accountant")

@Data
public class AccountantEntity extends PersonEntity {

}
