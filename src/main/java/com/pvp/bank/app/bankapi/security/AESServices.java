package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("AES")
@Service
public class AESServices implements EncryptionDecryptionService {

    @Override
    public String encryptResponse(BaseResponse baseResponse) throws BankException {
        return null;
    }

    @Override
    public String decryptRequest(String requestString) throws BankException {
        return null;
    }
}
