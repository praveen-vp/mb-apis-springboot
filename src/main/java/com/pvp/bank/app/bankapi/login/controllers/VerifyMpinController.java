package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.VerifyMpinService;
import com.pvp.bank.app.bankapi.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerifyMpinController {

    public VerifyMpinService verifyMpinService;

    public VerifyMpinController(VerifyMpinService verifyMpinService) {
        this.verifyMpinService = verifyMpinService;
    }


    @RequestMapping("/test")
    public Boolean test() {
        return this.verifyMpinService.verifyMpin(Customer.builder().mPin("123345").userId("1111").build());
    }

    @RequestMapping("/verifyMpin")
    public Boolean verifyMpin(Customer customer) {
        return this.verifyMpinService.verifyMpin(customer);
    }
}

