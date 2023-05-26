package com.co.horizontalproperty.domain.model.commons;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personType")
@Table(name = "person")

@Data
public abstract class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    private String active;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String gender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

}
