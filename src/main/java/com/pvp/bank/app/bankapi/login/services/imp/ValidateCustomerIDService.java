package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.ValidateCustomerIDProcedureCall;
import com.pvp.bank.app.bankapi.login.services.ValidateCustomerId;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ValidateCustomerIDService implements ValidateCustomerId {

    @Autowired
    private final ValidateCustomerIDProcedureCall procedureCall;

    public Boolean validateCustomerID(String userId) throws BankException {

        String responseCode = this.procedureCall.executeProcedure(userId);

        if (responseCode.equals(Appconstants.SUCCESS)) {
            return true;
        } else {
            throw new BankException(responseCode);
        }
    }
}
