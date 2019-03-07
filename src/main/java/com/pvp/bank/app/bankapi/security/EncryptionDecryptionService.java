package com.pvp.bank.app.bankapi.security;

public interface EncryptionDecryptionService {

    String encryptResponse(String responseString);

    String decryptRequest(String requestString);

}
