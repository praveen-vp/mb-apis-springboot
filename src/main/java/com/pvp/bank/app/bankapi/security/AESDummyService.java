package com.pvp.bank.app.bankapi.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class AESDummyService implements EncryptionDecryptionService {

    @Override
    public String encryptResponse(String responseString) {
        return "Dummy Response";
    }

    @Override
    public String decryptRequest(String responseString) {
        return responseString;
    }
}
