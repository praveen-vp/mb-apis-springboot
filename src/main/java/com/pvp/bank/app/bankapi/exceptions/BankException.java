package com.pvp.bank.app.bankapi.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BankException extends Exception {

    private String errorDesc;
    private String errorCode;

    public BankException(String errorCode) {
        this.errorCode = errorCode;
        this.errorDesc = getErrorMessage();
    }

    private String getErrorMessage() {
        return this.errorCode; // TODO need to do proper message handling from config
    }
}
