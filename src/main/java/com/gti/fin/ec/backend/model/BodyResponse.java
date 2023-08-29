package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class BodyResponse {

    @Getter
    @Setter
    private ResponseDebitPerson debitPerson;

    @Getter
    @Setter
    private String otp;

    @Getter
    @Setter
    private String token;


}
