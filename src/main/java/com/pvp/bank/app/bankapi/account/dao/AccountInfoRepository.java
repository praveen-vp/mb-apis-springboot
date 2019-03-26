package com.pvp.bank.app.bankapi.account.dao;

import com.pvp.bank.app.bankapi.account.models.AccountInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AccountInfoRepository extends CrudRepository<AccountInfo, Long> {
    Set<AccountInfo> getByUserId(String customerId);
}
