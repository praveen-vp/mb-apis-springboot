package com.pvp.bank.app.bankapi.models;

import com.pvp.bank.app.bankapi.base.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DCDetails extends BaseData {

    private Long dcNumber;
    private Integer cvv;
    private Integer dcPin;
    private Integer expMonth;
    private Integer expYear;

    private String name;
    private String action;
}
