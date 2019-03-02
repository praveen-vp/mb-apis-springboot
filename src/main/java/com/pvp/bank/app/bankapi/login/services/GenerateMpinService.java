package com.pvp.bank.app.bankapi.login.services;

import com.pvp.bank.app.bankapi.login.dao.GenerateMpinProcedureCall;
import com.pvp.bank.app.bankapi.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class GenerateMpinService {

    private final GenerateMpinProcedureCall generateMpinProcedureCall;
    private Customer customer;

    public GenerateMpinService(GenerateMpinProcedureCall generateMpinProcedureCall) {
        this.generateMpinProcedureCall = generateMpinProcedureCall;
    }

    private Boolean validateInputs() {
        return true;
    }

    public Boolean generateMpin(Customer customer) {
        this.customer = customer;
        validateInputs();
        generateMpinProcedureCall.executeProcedure(customer.getUserId(), customer.getMPin());
        return true;
    }
}
