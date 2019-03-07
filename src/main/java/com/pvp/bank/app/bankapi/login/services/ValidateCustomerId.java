package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface ValidateCustomerId {

    Boolean validateCustomerID(String userId) throws BankException;

}
