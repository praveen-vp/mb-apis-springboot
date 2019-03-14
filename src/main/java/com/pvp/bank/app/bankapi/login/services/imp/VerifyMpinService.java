package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.VerifyMpinProcedureCall;
import com.pvp.bank.app.bankapi.login.services.VerifyMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Data
@Service
public class VerifyMpinService implements VerifyMpin {

    @Autowired
    private final @NonNull VerifyMpinProcedureCall verifyMpinProcedureCall;
    private Customer customer;

    public Boolean validateMpinPattern() throws BankException {

        if (null != customer.getUserId() && null != customer.getMPin()) {
            // validateDcDetails userid according to the requirements

            // validateDcDetails mpin according to the requirements
            if (customer.getMPin().length() == 6) {
                try {
                    customer.setMPin(customer.mpinToSHA256());
                } catch (NoSuchAlgorithmException e) {
                    throw new BankException(e.getMessage());
                }
            }

            return true;
        }

        return false;
    }


    public Boolean verifyMpin(Customer customer) throws BankException {

        this.customer = customer;

        if (!validateMpinPattern()) {
            throw new BankException(Appconstants.INVALID_REQUEST);
        }

        String responseCode = verifyMpinProcedureCall.executeProcedure
                (customer.getUserId(), customer.getMPin());

        if (responseCode.equals(Appconstants.SUCCESS)) {
            return true;
        } else {
            throw new BankException(responseCode);
        }
    }
}
