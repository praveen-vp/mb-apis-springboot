package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.imp.ValidateCustomerIDService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class ValidateCustomerIDController {

    @Autowired
    private final ValidateCustomerIDService validateCustomerIDService;

    @RequestMapping("/ValidateCustomerId")
    public Boolean validateCustomerId(Customer customer) {
        return this.validateCustomerIDService.validateCustomerID(customer);
    }
}
