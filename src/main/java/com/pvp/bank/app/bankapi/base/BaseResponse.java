package com.pvp.bank.app.bankapi.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Data
@EqualsAndHashCode
@SuperBuilder
public class BaseResponse extends BaseModel {

    private String errorCode;
    private String errorDesc;
    private String appId;
    private String requestId;
    private BaseData data;
}
