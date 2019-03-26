package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class AESDummyService implements EncryptionDecryptionService {

    @Override
    public String encryptResponse(BaseResponse baseResponse) {
        System.out.println( " returning the dummy response --- ");
        return baseResponse.getResponseData();
    }

    @Override
    public String decryptRequest(String requestEncData) throws BankException {
        System.out.println( " returning the same request string --- ");
        return requestEncData;
    }
}
