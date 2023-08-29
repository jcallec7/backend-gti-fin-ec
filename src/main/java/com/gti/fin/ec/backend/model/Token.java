package com.gti.fin.ec.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Token {

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private String tokenRefresh;

}
