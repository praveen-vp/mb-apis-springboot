package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.exceptions.BankException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class RequestValidationService implements ValidationService<SecureBaseRequest> {

    @Override
    public Boolean validate(SecureBaseRequest object) throws BankException {
        return true; // TODO need to implement the details
    }
}
