package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.imp.VerifyMpinService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class VerifyMpinController {

    @Autowired
    public final VerifyMpinService verifyMpinService;

    @RequestMapping("/test")
    public Boolean test() {
        return this.verifyMpinService.verifyMpin(Customer.builder().mPin("123345").userId("1111").build());
    }

    @RequestMapping("/verifyMpin")
    public Boolean verifyMpin(Customer customer) {
        return this.verifyMpinService.verifyMpin(customer);
    }
}

