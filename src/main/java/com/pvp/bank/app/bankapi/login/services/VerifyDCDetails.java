package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.models.DCDetails;

public interface VerifyDCDetails {

    Boolean verifyDCPin(DCDetails details) throws BankException;

    void insertVerificationData(String userId, String appId) throws BankException;

    Boolean validateDcDetails(DCDetails dcDetails) throws BankException;
}
