package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.service.AccountValidation;

public class AccountValidationService implements AccountValidation {

    @Override
    public Boolean validateAccountAndUserId(String userId, String accountNumber) {
        return true;
    }
}
