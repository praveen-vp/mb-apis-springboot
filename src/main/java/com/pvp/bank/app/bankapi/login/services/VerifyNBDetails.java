package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.base.ValidationService;

public interface VerifyNBDetails extends ValidationService {

    Boolean verifyNBPassword(String nbUserId, String nbPassword);
}
