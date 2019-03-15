package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.GenerateMpinProcedureCall;
import com.pvp.bank.app.bankapi.login.services.GenerateMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class GenerateMpinService implements GenerateMpin {

    @Autowired
    private @NonNull GenerateMpinProcedureCall generateMpinProcedureCall;
    private Customer customer;

    private Boolean validateInputs() {
        return true;
    }

    public Boolean generateMpin(Customer customer) throws BankException {

        this.customer = customer;
        System.out.println(customer);

        if (validateInputs()) {
            String errorCode = this.generateMpinProcedureCall.generateMpin(
                    customer.getUserId(), customer.getMPin());

            if (errorCode.equals(Appconstants.SUCCESS)) {
                return true;
            } else {
                throw new BankException(errorCode);
            }
        } else {
            throw new BankException(Appconstants.CUST_ID_VALIDATION_FAILED);
        }
    }
}
