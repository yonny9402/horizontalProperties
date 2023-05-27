package com.co.terrax.domain.model.horizontalproperties.module.finance.income;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "income")
@Getter
@Setter

public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String source;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

}
