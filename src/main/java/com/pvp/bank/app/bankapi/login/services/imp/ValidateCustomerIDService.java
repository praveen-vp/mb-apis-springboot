package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.ValidateCustomerIDProcedureCall;
import com.pvp.bank.app.bankapi.login.services.ValidateCustomerId;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Data
@Service
@Profile("default")
public class ValidateCustomerIDService implements ValidateCustomerId {

    @Autowired
    private final ValidateCustomerIDProcedureCall procedureCall;

    @Override
    public Boolean validateCustomerID(String userId) throws BankException {

        String responseCode = this.procedureCall.executeProcedure(userId);

        if (responseCode.equals(Appconstants.SUCCESS)) {
            return true;
        } else {
            throw new BankException(responseCode);
        }
    }
}
