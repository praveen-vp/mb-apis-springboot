package com.pvp.bank.app.bankapi.login.services;

public interface VerifyOTP<T> {

    Boolean verifyOtp(T type);

    Boolean validateInput();
}
