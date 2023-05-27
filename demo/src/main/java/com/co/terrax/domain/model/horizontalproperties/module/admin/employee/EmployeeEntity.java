package com.co.terrax.domain.model.horizontalproperties.module.admin.employee;

import com.co.terrax.domain.model.horizontalproperties.module.admin.commons.PersonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("employee")
@Getter
@Setter
public class EmployeeEntity extends PersonEntity {

    private String position;
    private double salary;

}
