package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseData;

public interface EncryptionDecryptionService {

    String encryptResponse(String responseString);

    BaseData decryptRequest(String requestString);

}
