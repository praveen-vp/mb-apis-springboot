package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface VerifyNBDetails {

    Boolean verifyNBPassword(String nbUserId, String nbPassword) throws BankException;
}
