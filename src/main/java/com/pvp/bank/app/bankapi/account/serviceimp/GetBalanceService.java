package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.dao.AccountBalanceRepository;
import com.pvp.bank.app.bankapi.account.models.AccountBalanceInfo;
import com.pvp.bank.app.bankapi.account.service.GetBalance;
import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class GetBalanceService extends AccountValidationService implements GetBalance {

    @Autowired
    private final AccountBalanceRepository accountBalanceRepository;

    @Override
    public Double getAvailableBalance(String userId, String accountNumber) throws BankException{

        if (!validateAccountAndUserId(userId, accountNumber)) {
            throw new BankException(Appconstants.INVALID_REQUEST);
        }

        AccountBalanceInfo accountBalanceInfo = this.accountBalanceRepository.findByAccountNumber(accountNumber);
        return accountBalanceInfo != null ? accountBalanceInfo.getAvailableBalance() : 0.00;
    }

    @Override
    public Double getEffectiveBalance(String userId, String accountNumber) throws BankException {

        if (!validateAccountAndUserId(userId, accountNumber)) {
            throw new BankException(Appconstants.INVALID_REQUEST);
        }

        AccountBalanceInfo accountBalanceInfo = this.accountBalanceRepository.findByAccountNumber(accountNumber);
        return accountBalanceInfo != null ? accountBalanceInfo.getEffectiveBalance() : 0.00;
    }
}
