package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.VerifyMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyMpinController extends BaseController<Customer> {

    @Autowired
    public final VerifyMpin verifyMpinService;

    /**
     * @param encryptionDecryptionService
     * @param validationService
     * @param verifyMpinService
     */
    public VerifyMpinController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                @NonNull ValidationService validationService,
                                @NonNull VerifyMpin verifyMpinService) {
        super(encryptionDecryptionService, validationService);
        this.verifyMpinService = verifyMpinService;
        this.requestData = new Customer();
    }

    @RequestMapping(value = "/VerifyMpin", method = RequestMethod.POST)
    public BaseResponse verifyMpin(@RequestBody SecureBaseRequest baseRequest) {
        System.out.println(baseRequest);
        return super.process(baseRequest);
    }

    @Override
    public void requestHandler() throws BankException {
        this.requestStatus = verifyMpinService.verifyMpin(requestData);
    }
}

