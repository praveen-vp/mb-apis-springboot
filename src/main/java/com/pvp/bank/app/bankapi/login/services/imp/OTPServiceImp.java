package com.pvp.bank.app.bankapi.login.services.imp;

import com.pvp.bank.app.bankapi.dao.CustomerCrudService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.GenerateOTPProcedureCall;
import com.pvp.bank.app.bankapi.login.dao.VerifyOTPProcedureCall;
import com.pvp.bank.app.bankapi.login.services.OTPService;
import com.pvp.bank.app.bankapi.models.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class OTPServiceImp implements OTPService {

    @Autowired
    private final CustomerCrudService customerCrudService;
    @Autowired
    private final GenerateOTPProcedureCall generateOtpProcedureCall;
    @Autowired
    private final VerifyOTPProcedureCall verifyOTPProcedureCall;

    @Override
    public Integer generateOtp(String userId, String appId) {
        return generateOtpProcedureCall.generateOtp(userId, appId);
    }

    @Override
    public Boolean sendOTPByCall(Customer customer) throws BankException {

        Integer mobile = getRegisteredMobileNumber(customer.getUserId());
        Integer otp = generateOtp(customer.getUserId(), customer.getAppId());

        // TODO need to implement service to send sms using an api call
        System.out.println(" >> sending OTP by call  mobile : " + mobile + " OTP : " + otp);
        return true;
    }

    @Override
    public Boolean sendOTP(Integer otp, String userId) throws BankException {

        Integer mobile = getRegisteredMobileNumber(userId);

        // TODO need to implement service to send sms using procedure (preferably) or an api call
        System.out.println(" >> sending OTP to mobile number : " + mobile + " OTP : " + otp);

        return true;
    }

    @Override
    public Integer getRegisteredMobileNumber(String userId) throws BankException {
        return this.customerCrudService.getMobileByUserId(userId);
    }

    @Override
    public Boolean verifyOtp(Customer customer) {
        validateInput(customer);
        System.out.println(" validating otp for the user : " + customer.getUserId() + " for otp : " + customer.getOtp());
        this.verifyOTPProcedureCall.verifyOTP(customer.getUserId(),
                customer.getAppId(), customer.getOtp());
        return true;
    }

    @Override
    public Boolean validateInput(Customer customer) {
        System.out.println(" validating the input for otp");
        return true;
    }
}
