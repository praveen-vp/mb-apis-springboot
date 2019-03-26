package com.pvp.bank.app.bankapi.account.models;

import com.pvp.bank.app.bankapi.base.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode
@MappedSuperclass
public class BaseAcctObj extends BaseData {
    private String accountNumber;
}
