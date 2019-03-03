package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.models.Customer;
import com.pvp.bank.app.bankapi.security.AESEncyptionService;
import com.pvp.bank.app.bankapi.security.EncryptionService;

public class BaseService {

    EncryptionService<Customer, String> encryptionService;

    public BaseService() {
        this.encryptionService = new AESEncyptionService();
    }

    public Customer decryptRequest(String requestString) {
        return encryptionService.decryptRequest(requestString);
    }

    public String encryptResponse(Customer response) {
        return encryptionService.encryptResponse(response);
    }
}
