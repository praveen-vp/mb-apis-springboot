package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.exceptions.BankException;

public interface EncryptionDecryptionService {

    String encryptResponse(BaseResponse baseResponse) throws BankException;

    String decryptRequest(String requestString) throws BankException;

}
