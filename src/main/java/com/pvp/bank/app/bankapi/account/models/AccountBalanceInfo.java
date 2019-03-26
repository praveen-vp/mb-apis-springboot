package com.pvp.bank.app.bankapi.account.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode
public class AccountBalanceInfo extends BaseAcctObj {
    private Double effectiveBalance;
    private Double availableBalance;
}
