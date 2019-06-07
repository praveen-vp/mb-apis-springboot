package com.pvp.bank.app.bankapi.fundtransfer.history;

public interface FundTransferHistoryService<T> {

    T getTransferHistory(Long crn, Long accountNumber, String transferType);
}
