package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.dao.VerifyOTPProcedureCall;
import com.pvp.bank.app.bankapi.login.services.VerifyOTP;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class VerifyOTPService implements VerifyOTP<Customer> {

    @Autowired
    private final VerifyOTPProcedureCall verifyOTPProcedureCall;
    Customer customer;

    public Boolean validateInput() {
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
