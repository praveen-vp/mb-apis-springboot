package com.pvp.bank.app.bankapi.account.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "transaction_history")
public class TransactionHistoryObj extends BaseAcctObj {

    private String description;
    private String referenceNumber;
    private Date createdDate = new Date(System.currentTimeMillis());
    private Date updateDate;
    private Double amount;
}
