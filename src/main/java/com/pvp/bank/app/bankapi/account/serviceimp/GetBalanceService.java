package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.models.AccountBalanceObj;
import com.pvp.bank.app.bankapi.account.service.GetBalance;
import com.pvp.bank.app.bankapi.baseservice.AbstractBaseService;
import lombok.Data;

@Data
public class GetBalanceService extends AbstractBaseService implements GetBalance {


    @Override
    public AccountBalanceObj getBalance() {
        return null;
    }
}
