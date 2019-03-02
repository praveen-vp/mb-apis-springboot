package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.login.dao.VerifyMpinProcedureCall;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@Service
public class VerifyMpinService {

    private Customer customer;
    private final VerifyMpinProcedureCall verifyMpinProcedureCall;

    public VerifyMpinService(VerifyMpinProcedureCall verifyMpinProcedureCall) {
        this.verifyMpinProcedureCall = verifyMpinProcedureCall;
    }


    private boolean validateMpinPattern() {

        if (null != customer.getUserId() && null != customer.getMPin()) {
            // validate userid according to the requirements

            // validate mpin according to the requirements
            //if ok then convert it to SHA-256 and set it again

            customer.setMPin(customer.toSHA256());

            return true;
        }

        return false;
    }


    public boolean verifyMpin(Customer customer) {

        this.customer = customer;

        if (!validateMpinPattern()) {
            throw new RuntimeException("Invalid Input Details");
        }

        String responseCode = verifyMpinProcedureCall.executeProcedure(customer.getUserId(), customer.getMPin());
        return responseCode.equals("0000");
    }
}
