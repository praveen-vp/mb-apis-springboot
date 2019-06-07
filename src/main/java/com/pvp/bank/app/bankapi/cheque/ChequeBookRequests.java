package com.pvp.bank.app.bankapi.cheque;

public interface ChequeBookRequests {

    String getChequeBookStatus(Long crn, Long accountNumber, String cheque);

    String stopCheque(Long crn, Long accountNumber, String chequeNumber);

    String applyChequeBook(Long crn, Long accountNumber);
}
