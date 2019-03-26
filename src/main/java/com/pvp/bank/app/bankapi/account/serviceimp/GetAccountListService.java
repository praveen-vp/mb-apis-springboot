package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.dao.AccountInfoRepository;
import com.pvp.bank.app.bankapi.account.models.AccountInfo;
import com.pvp.bank.app.bankapi.account.service.GetAccountList;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Data
public class GetAccountListService implements GetAccountList {

    @Autowired
    private final AccountInfoRepository accountInfoRepository;

    @Override
    public Set<AccountInfo> getAccountList(String customerId) {
        return this.accountInfoRepository.getByUserId(customerId);
    }
}
