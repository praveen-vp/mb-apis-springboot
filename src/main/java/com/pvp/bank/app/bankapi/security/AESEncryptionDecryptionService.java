package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseData;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class AESEncryptionDecryptionService implements EncryptionDecryptionService {

    @Override
    public String encryptResponse(String responseString) {
        return null;
    }

    @Override
    public BaseData decryptRequest(String responseString) {
        return null;
    }
}
