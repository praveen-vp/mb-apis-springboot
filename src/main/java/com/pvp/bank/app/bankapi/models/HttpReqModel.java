package com.pvp.bank.app.bankapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class HttpReqModel extends BaseEntity {

    private final String apiUrl;
    private String proxy;
    private String certificate = "";
    private String contentType = "application/Json";
    private String method = "POST";
}
