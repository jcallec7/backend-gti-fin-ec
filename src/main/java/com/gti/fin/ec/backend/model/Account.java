package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Account {

    @Getter
    @Setter
    private String debitAccountType;

    @Getter
    @Setter
    private String account;

    @Getter
    @Setter
    private String alias;
}
