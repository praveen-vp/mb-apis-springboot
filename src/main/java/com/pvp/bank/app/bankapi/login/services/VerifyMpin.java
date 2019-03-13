package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.models.Customer;

public interface VerifyMpin {

    Boolean validateMpinPattern() throws BankException;

    Boolean verifyMpin(Customer customer) throws BankException;
}
