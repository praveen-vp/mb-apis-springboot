package com.pvp.bank.app.bankapi.fundtransfer.beneficiary;

public interface BeneficiaryServices {

    Long addBeneficiary(String accountNumber, String ifsc, String bankName, String accountType);

    Boolean activateBeneficiary(Long benefUniqNo);

    Boolean deActivateBenefiaciary(Long benefUniqNo);

}
