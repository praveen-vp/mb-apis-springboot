package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.models.Customer;

public interface OTPByCall {

    Boolean sendOTPByCall(Customer customer);

}
