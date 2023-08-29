package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
public class ResponseDebitPerson {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String identification;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private List<Account> accounts;

}
