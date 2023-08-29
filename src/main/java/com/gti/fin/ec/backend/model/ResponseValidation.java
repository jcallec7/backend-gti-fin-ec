package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ResponseValidation {

    @Getter
    @Setter
    private ResponseDebitPerson debitPerson;

    @Getter
    @Setter
    private String idTrx;

    @Getter
    @Setter
    private String otp;

}
