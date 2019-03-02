package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.login.dao.VerifyOTPProcedureCall;
import com.pvp.bank.app.bankapi.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class VerifyOTPService {

    private final VerifyOTPProcedureCall verifyOTPProcedureCall;
    Customer customer;

    public VerifyOTPService(VerifyOTPProcedureCall verifyOTPProcedureCall) {
        this.verifyOTPProcedureCall = verifyOTPProcedureCall;
    }

    private Boolean validateInput() {
        return true;
    }

    public Boolean verifyOtp(Customer customer) {
        this.customer = customer;

        validateInput();

        this.verifyOTPProcedureCall.executeProcedure(customer.getUserId(),
                customer.getAppId(), customer.getOtp());
        return true;
    }
}
