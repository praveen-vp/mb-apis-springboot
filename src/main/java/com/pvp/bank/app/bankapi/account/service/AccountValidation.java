package com.pvp.bank.app.bankapi.account.service;

public interface AccountValidation {

    Boolean validateAccountAndUserId(String userId, String accountNumber);
}
