package com.pvp.bank.app.bankapi.account.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class AccountStatementObj extends TransactionHistoryObj {
    private String fromDate;
    private String endDate;
}
