package com.pvp.bank.app.bankapi.security;

import com.pvp.bank.app.bankapi.models.Customer;

public class AESEncyptionService implements EncryptionService <Customer ,String> {

    @Override
    public String encryptResponse(Customer responseString) {
        return null;
    }

    @Override
    public Customer decryptRequest(String responseString) {
        return null;
    }
}
