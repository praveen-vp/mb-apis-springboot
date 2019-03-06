package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface ValidationService<T> {

    Boolean validate(T object) throws BankException;
}
