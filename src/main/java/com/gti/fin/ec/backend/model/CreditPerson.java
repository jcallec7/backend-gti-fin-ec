package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CreditPerson {

    @Getter
    @Setter
    private String institution;

    @Getter
    @Setter
    private String identificationType;

    @Getter
    @Setter
    private String identification;

    @Getter
    @Setter
    private String accountType;

    @Getter
    @Setter
    private String account;
}
