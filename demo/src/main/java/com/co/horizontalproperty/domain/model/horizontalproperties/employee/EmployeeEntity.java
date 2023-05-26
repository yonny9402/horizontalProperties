package com.co.horizontalproperty.domain.model.horizontalproperties.employee;

import com.co.horizontalproperty.domain.model.commons.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("employee")

@Data
public class EmployeeEntity extends PersonEntity {

    private String position;
    private double salary;

}
