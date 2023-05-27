package com.co.terrax.domain.model.horizontalproperties.commons;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class ResponseExeptionEntity {

    private String statusHppt;
    private String reason;
    private String codeError;

}



