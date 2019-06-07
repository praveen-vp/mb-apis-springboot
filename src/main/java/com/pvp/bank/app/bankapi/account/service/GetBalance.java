package com.pvp.bank.app.bankapi.account.service;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface GetBalance {

    Double getAvailableBalance(String userId, String accountNumber) throws BankException;

    Double getEffectiveBalance(String userId, String accountNumber) throws BankException;

}
