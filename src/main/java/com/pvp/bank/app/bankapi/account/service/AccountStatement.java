package com.pvp.bank.app.bankapi.account.service;

public interface AccountStatement<T, U> {

    T getStatement(U type);

}
