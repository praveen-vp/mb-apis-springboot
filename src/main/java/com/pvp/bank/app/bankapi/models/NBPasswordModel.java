package com.pvp.bank.app.bankapi.models;

import com.pvp.bank.app.bankapi.base.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NBPasswordModel extends BaseData {
    private String password;
    private String actionFor;
}
