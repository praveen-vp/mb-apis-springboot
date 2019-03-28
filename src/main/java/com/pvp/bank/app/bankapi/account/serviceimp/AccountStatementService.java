package com.pvp.bank.app.bankapi.account.serviceimp;

import com.pvp.bank.app.bankapi.account.dao.AccountStatementRepository;
import com.pvp.bank.app.bankapi.account.models.AccountStatementObj;
import com.pvp.bank.app.bankapi.account.models.TransactionHistoryObj;
import com.pvp.bank.app.bankapi.account.service.AccountStatement;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Data
public class AccountStatementService implements AccountStatement<Set<TransactionHistoryObj>, AccountStatementObj> {

    @Autowired
    private final AccountStatementRepository accountStatementRepository;

    public AccountStatementService(@NonNull AccountStatementRepository accountStatementRepository) {
        this.accountStatementRepository = accountStatementRepository;
    }

    @Override
    public Set<TransactionHistoryObj> getStatement(AccountStatementObj statementObj) {
        return accountStatementRepository.getTransactionHistory(statementObj.getFromDate(),
                statementObj.getEndDate(), statementObj.getUserId(), statementObj.getAccountNumber());
    }
}
