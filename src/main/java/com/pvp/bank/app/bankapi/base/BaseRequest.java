package com.pvp.bank.app.bankapi.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@ToString
public class BaseRequest extends BaseModel {

    private String appId;
    private BaseData data;
}
