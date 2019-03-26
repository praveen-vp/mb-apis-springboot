package com.pvp.bank.app.bankapi.account.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode
public class AccountInfo extends BaseAcctObj {
    private String accountType;
    private String branchCode;
    private String accountName;
}
