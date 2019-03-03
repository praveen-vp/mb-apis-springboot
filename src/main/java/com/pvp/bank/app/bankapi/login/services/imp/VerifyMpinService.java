package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.dao.VerifyMpinProcedureCall;
import com.pvp.bank.app.bankapi.login.services.VerifyMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class VerifyMpinService implements VerifyMpin {

    @Autowired
    private final VerifyMpinProcedureCall verifyMpinProcedureCall;
    private Customer customer;

    public Boolean validateMpinPattern() {

        if (null != customer.getUserId() && null != customer.getMPin()) {
            // validate userid according to the requirements

            // validate mpin according to the requirements
            //if ok then convert it to SHA-256 and set it again

            customer.setMPin(customer.mpinToSHA256());

            return true;
        }

        return false;
    }


    public Boolean verifyMpin(Customer customer) {

        this.customer = customer;

        if (!validateMpinPattern()) {
            throw new RuntimeException("Invalid Input Details");
        }

        String responseCode = verifyMpinProcedureCall.executeProcedure(customer.getUserId(), customer.getMPin());
        return responseCode.equals("0000");
    }
}
