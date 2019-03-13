package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.imp.VerifyOTPService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Data
@Controller
public class OTPController {

    @Autowired
    private final VerifyOTPService verifyOTPService;

    @RequestMapping(value = "/testotp", method = RequestMethod.POST)
    public Boolean test(@RequestBody Customer customer) {
        return this.verifyOTPService.verifyOtp(customer);
    }

    @RequestMapping("/Login/verifyOTP")
    public Boolean verifyOtp(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.CustomerBuilder().appId("123345").userId("1111").otp(123456).build());
    }

    @RequestMapping("/Login/ResendOTP")
    public Boolean resendOTP(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.CustomerBuilder().appId("123345").userId("1111").otp(123456).build());
    }

    @RequestMapping("/Login/SendOTPByCall")
    public Boolean sendOTPByCall(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.CustomerBuilder().appId("123345").userId("1111").otp(123456).build());
    }
}
