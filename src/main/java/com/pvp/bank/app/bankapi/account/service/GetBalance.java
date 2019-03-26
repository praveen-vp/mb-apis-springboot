package com.pvp.bank.app.bankapi.account.service;

public interface GetBalance {

    Double getAvailableBalance(String accountNumber);

    Double getEffectiveBalance(String accountNumber);

}
