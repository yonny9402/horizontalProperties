package com.example.demo.domain.model.horizontalproperties.administrator;

import com.example.demo.domain.model.commons.PersonEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("administrator")

@Data
public class AdministratorEntity extends PersonEntity {

}
