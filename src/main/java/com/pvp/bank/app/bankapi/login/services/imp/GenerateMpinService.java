package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.dao.GenerateMpinProcedureCall;
import com.pvp.bank.app.bankapi.models.Customer;
import com.pvp.bank.app.bankapi.login.services.GenerateMpin;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class GenerateMpinService implements GenerateMpin {

    @Autowired
    private final GenerateMpinProcedureCall generateMpinProcedureCall;
    private Customer customer;

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
