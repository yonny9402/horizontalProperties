package com.example.demo.domain.model.horizontalproperties.accountant;

import com.example.demo.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@DiscriminatorValue("accountant")

@Data
public class AccountantEntity extends PersonEntity {

}
