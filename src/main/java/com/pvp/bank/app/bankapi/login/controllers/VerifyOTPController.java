package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.VerifyOTPService;
import com.pvp.bank.app.bankapi.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerifyOTPController {

    private final VerifyOTPService verifyOTPService;

    public VerifyOTPController(VerifyOTPService verifyOTPService) {
        this.verifyOTPService = verifyOTPService;
    }

    @RequestMapping("/testotp")
    public Boolean test() {
        return this.verifyOTPService.verifyOtp(
                Customer.builder().appId("123345").userId("1111").otp(123456).build());
    }
}
