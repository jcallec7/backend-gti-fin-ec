package com.gti.fin.ec.backend.controller;

import com.gti.fin.ec.backend.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    @GetMapping
    private ResponseEntity getAccount() {

        String tokenUrl = "https://devservicios.gti.fin.ec/seguridades-api-ws-1.0/coopagos/token";
        String validationUrl = "https://desarrollo.gti.fin.ec/boton-web-api-ws-1.0/coopagos/web/private/validation";

        User user = new User();
        user.setUsuario("gti");
        user.setClave("aY9T1MFpCWnwuuuMYe030sEUVG1ZXPe1");

        DebitPerson debitPerson = new DebitPerson();
        debitPerson.setInstitution("2");
        debitPerson.setIdentificationType("C");
        debitPerson.setIdentification("0105213136");
        debitPerson.setAccountType("1");
        debitPerson.setAccount("2269539");

        CreditPerson creditPerson = new CreditPerson();
        creditPerson.setInstitution("2");
        creditPerson.setIdentificationType("C");
        creditPerson.setIdentification("0102514106");
        creditPerson.setAccountType("1");
        creditPerson.setAccount("100004");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<Token> responseToken = restTemplate.postForEntity(tokenUrl, request, Token.class);

        Token token = responseToken.getBody();

        Validation validation = new Validation();
        validation.setChanel("ELAKE");
        validation.setDebitPerson(debitPerson);
        validation.setCreditPerson(creditPerson);
        validation.setAmount("1.0");
        validation.setAmountDelivery("0.0");
        validation.setOrderId("1");
        validation.setOtp("12345");
        validation.setIp("192.168.1.1");

        headers.add("Authorization", "Bearer " + token.getToken());

        HttpEntity<Validation> requestValidation = new HttpEntity<>(validation, headers);

        ResponseEntity<ResponseValidation> responseValidation = restTemplate.postForEntity(validationUrl, requestValidation, ResponseValidation.class);

        BodyResponse bodyResponse = new BodyResponse();
        bodyResponse.setDebitPerson(responseValidation.getBody().getDebitPerson());
        bodyResponse.setOtp(responseValidation.getBody().getOtp());
        bodyResponse.setToken(token.getToken());

        ResponseEntity<BodyResponse> requestBodyResponse = ResponseEntity.ok(bodyResponse);

        return requestBodyResponse;
    }

}
