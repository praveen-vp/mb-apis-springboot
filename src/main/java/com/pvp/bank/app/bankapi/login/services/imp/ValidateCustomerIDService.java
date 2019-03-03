package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.login.dao.ValidateCustomerIDProcedureCall;
import com.pvp.bank.app.bankapi.login.services.ValidateCustomerId;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ValidateCustomerIDService implements ValidateCustomerId {

    @Autowired
    private final ValidateCustomerIDProcedureCall procedureCall;

    public Boolean validateCustomerID(Customer customer) {
        this.procedureCall.executeProcedure(customer.getUserId());
        return true;
    }
}
