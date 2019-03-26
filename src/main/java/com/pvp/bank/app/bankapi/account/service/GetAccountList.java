package com.pvp.bank.app.bankapi.account.service;

import com.pvp.bank.app.bankapi.account.models.AccountInfo;

import java.util.Set;

public interface GetAccountList {

    Set<AccountInfo> getAccountList(String customerId);

}
