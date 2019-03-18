package com.pvp.bank.app.bankapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HttpRespModel {
    private String apiRespCode;
    private String apiRespMessage;
    private String apiResponse;
}
