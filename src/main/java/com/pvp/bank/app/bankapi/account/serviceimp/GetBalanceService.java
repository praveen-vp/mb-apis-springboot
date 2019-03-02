package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.models.AccountBalanceObj;
import com.pvp.bank.app.bankapi.account.service.GetBalance;
import com.pvp.bank.app.bankapi.baseservice.AbstractBaseService;

public class GetBalanceService extends AbstractBaseService implements GetBalance {

    public GetBalanceService(String userId, String appId) {
        super(userId, appId);
    }

    @Override
    public AccountBalanceObj getBalance() {
        return null;
    }
}
