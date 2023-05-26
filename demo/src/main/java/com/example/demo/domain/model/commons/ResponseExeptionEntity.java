package com.example.demo.domain.model.commons;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ResponseExeptionEntity {

    private String statusHppt;
    private String reason;
    private String codeError;

}



