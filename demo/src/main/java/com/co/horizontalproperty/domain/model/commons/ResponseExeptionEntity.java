package com.co.horizontalproperty.domain.model.commons;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ResponseExeptionEntity {

    private String statusHppt;
    private String reason;
    private String codeError;

}



