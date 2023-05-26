package com.example.demo.domain.model.horizontalproperties.complex;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "complex")
@Data
public class ComplexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complexId;
    private String name;
    private String description;
    private String category;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    private String status;
    private String image;

}