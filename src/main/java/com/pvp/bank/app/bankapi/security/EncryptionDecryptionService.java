package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface EncryptionDecryptionService {

    String encryptResponse(String responseString);

    String decryptRequest(String requestString) throws BankException;

}
