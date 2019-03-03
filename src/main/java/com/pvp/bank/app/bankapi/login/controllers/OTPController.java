package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.login.services.imp.VerifyOTPService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class OTPController {

    @Autowired
    private final VerifyOTPService verifyOTPService;

    @RequestMapping("/testotp")
    public Boolean test() {
        return this.verifyOTPService.verifyOtp(
                Customer.builder().appId("123345").userId("1111").otp(123456).build());
    }

    @RequestMapping("/Login/verifyOTP")
    public Boolean verifyOtp(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.builder().appId("123345").userId("1111").otp(123456).build());
    }

    @RequestMapping("/Login/ResendOTP")
    public Boolean resendOTP(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.builder().appId("123345").userId("1111").otp(123456).build());
    }

    @RequestMapping("/Login/SendOTPByCall")
    public Boolean sendOTPByCall(Customer customer) {
        return this.verifyOTPService.verifyOtp(
                Customer.builder().appId("123345").userId("1111").otp(123456).build());
    }
}
