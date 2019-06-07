package com.pvp.bank.app.bankapi.account.service;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface AccountStatement<T, U> {

    T getStatement(U type) throws BankException;

}
