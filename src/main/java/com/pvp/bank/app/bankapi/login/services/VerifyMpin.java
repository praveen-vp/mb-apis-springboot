package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.models.Customer;

public interface VerifyMpin {

    Boolean validateMpinPattern();

    Boolean verifyMpin(Customer customer);
}
