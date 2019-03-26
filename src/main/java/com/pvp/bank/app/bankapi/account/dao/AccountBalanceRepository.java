package com.pvp.bank.app.bankapi.account.dao;

import com.pvp.bank.app.bankapi.account.models.AccountBalanceInfo;
import org.springframework.data.repository.CrudRepository;

public interface AccountBalanceRepository extends CrudRepository<AccountBalanceInfo, Long> {
    AccountBalanceInfo findByAccountNumber(String accountNumber);
}
