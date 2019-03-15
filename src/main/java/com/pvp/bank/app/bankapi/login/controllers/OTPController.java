package com.pvp.bank.app.bankapi.login.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @RequestMapping(value = "/OTP/{url}", method = RequestMethod.POST)
    public BaseResponse controllerHandle(@PathVariable String url,
                                         @RequestBody SecureBaseRequest baseRequest) {
        System.out.println(" request received " + baseRequest.toString());
        this.request = url;
        System.out.println(" actual URL : /OTP/" + url);
        return controllerHandle(baseRequest);
    }

    @Override
    public BaseResponse controllerHandle(SecureBaseRequest baseRequest) {
        return super.process(baseRequest);
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
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Invalid Request"
                );
        }
    }
}
