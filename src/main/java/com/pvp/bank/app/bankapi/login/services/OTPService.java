package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.models.Customer;

public interface OTPService {

    Boolean sendOTP(Integer otp, String userId) throws BankException;

    Integer getRegisteredMobileNumber(String userId) throws BankException;

    Boolean sendOTPByCall(Customer customer) throws BankException;

    Boolean verifyOtp(Customer customer);

    Boolean validateInput(Customer customer);

    Integer generateOtp(String userId, String appId);
}
