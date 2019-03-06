package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.dao.GenerateMpinProcedureCall;
import com.pvp.bank.app.bankapi.login.services.GenerateMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class GenerateMpinService implements GenerateMpin {

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
        this.generateMpinProcedureCall.executeProcedure(customer.getUserId(), customer.getMPin());
        return true;
    }
}
