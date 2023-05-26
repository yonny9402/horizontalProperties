package com.example.demo.domain.model.horizontalproperties.property;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "property")
@Data
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;
    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private String yearBuilt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    private String status;

}
