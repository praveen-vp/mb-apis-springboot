package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.models.Customer;

public interface GenerateMpin {

    Boolean generateMpin(Customer customer) throws BankException;

}
