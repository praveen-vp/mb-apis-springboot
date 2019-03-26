package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.dao.AccountBalanceRepository;
import com.pvp.bank.app.bankapi.account.models.AccountBalanceInfo;
import com.pvp.bank.app.bankapi.account.service.GetBalance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class GetBalanceService implements GetBalance {

    @Autowired
    private final AccountBalanceRepository accountBalanceRepository;

    @Override
    public Double getAvailableBalance(String accountNumber) {
        AccountBalanceInfo accountBalanceInfo = this.accountBalanceRepository.findByAccountNumber(accountNumber);
        return accountBalanceInfo != null ? accountBalanceInfo.getAvailableBalance() : 0.00;
    }

    @Override
    public Double getEffectiveBalance(String accountNumber) {
        AccountBalanceInfo accountBalanceInfo = this.accountBalanceRepository.findByAccountNumber(accountNumber);
        return accountBalanceInfo != null ? accountBalanceInfo.getEffectiveBalance() : 0.00;
    }
}
