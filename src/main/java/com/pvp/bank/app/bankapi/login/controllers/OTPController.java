package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.appconstants.RequestConstants;
import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.OTPService;
import com.pvp.bank.app.bankapi.models.Customer;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@EqualsAndHashCode(callSuper = false)
@RestController
public class OTPController extends BaseController<Customer> {

    @Autowired
    private final OTPService otpService;
    private String request = RequestConstants.OTP_VERIFY;

    public OTPController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                         @NonNull ValidationService validationService,
                         @NonNull OTPService otpService) {
        super(encryptionDecryptionService, validationService);
        this.otpService = otpService;
        this.requestData = new Customer();
    }

    @Override
    public void requestHandler() throws BankException {

        this.requestData.setAppId(secBaseRequest.getApplicationId());

        switch (request) {
            case RequestConstants.RESEND_OTP:
                Integer otp = otpService.generateOtp(requestData.getUserId(), secBaseRequest.getApplicationId());
                this.requestStatus = this.otpService.sendOTP(otp, requestData.getUserId());
                break;

            case RequestConstants.OTP_BY_CALL:
                this.requestStatus = this.otpService.sendOTPByCall(requestData);
                break;

            case RequestConstants.OTP_VERIFY:
                this.otpService.verifyOtp(requestData);
                break;

            default:
                throw new BankException(Appconstants.INVALID_REQUEST);
        }
    }

    @RequestMapping(value = "/OTP/{id}", method = RequestMethod.POST)
    public BaseResponse verifyOtp(@PathVariable String id, @RequestBody SecureBaseRequest baseRequest) {
        System.out.println(" request received " + baseRequest.toString());
        // path variable values
        this.request = id;
        System.out.println( " path variable " + id);
        return super.process(baseRequest);
    }
}
