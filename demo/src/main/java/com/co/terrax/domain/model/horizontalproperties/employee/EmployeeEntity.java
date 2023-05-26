package com.co.terrax.domain.model.horizontalproperties.employee;

import com.co.terrax.domain.model.commons.PersonEntity;
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
