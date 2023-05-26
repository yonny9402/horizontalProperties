package com.example.demo.domain.model.horizontalproperties.owner;

import com.example.demo.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("owner")

@Data
public class OwnerEntity extends PersonEntity {

}
