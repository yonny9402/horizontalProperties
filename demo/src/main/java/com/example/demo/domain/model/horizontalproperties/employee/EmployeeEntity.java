package com.example.demo.domain.model.horizontalproperties.employee;

import com.example.demo.domain.model.commons.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@DiscriminatorValue("employee")

@Data
public class EmployeeEntity extends PersonEntity {

    private String position;
    private double salary;

}
