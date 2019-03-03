package com.pvp.bank.app.bankapi.security;

public interface EncryptionService<T, U> {

    U encryptResponse(T responseString);

    T decryptRequest(U responseString);

}
