package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseData;
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
        return new BaseData().builder().userId("dummy userID from AES Dummy Service").build().toJson();
    }
}
