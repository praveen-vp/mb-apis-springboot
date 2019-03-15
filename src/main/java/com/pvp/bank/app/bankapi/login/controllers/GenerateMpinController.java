package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.GenerateMpin;
import com.pvp.bank.app.bankapi.models.Customer;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateMpinController extends BaseController<Customer> {

    @Autowired
    private final @NonNull GenerateMpin generateMpinService;

    public GenerateMpinController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                  @NonNull ValidationService validationService,
                                  @NonNull GenerateMpin generateMpinService) {
        super(encryptionDecryptionService, validationService);
        this.generateMpinService = generateMpinService;
        this.requestData = new Customer();
    }

    @Override
    @RequestMapping(value = "/GenerateMpin", method = RequestMethod.POST)
    public BaseResponse controllerHandle(@RequestBody SecureBaseRequest baseRequest) {
        System.out.println("Request Received -- " + baseRequest);
        return super.process(baseRequest);
    }

    @Override
    public void requestHandler() throws BankException {
        this.requestStatus = generateMpinService.generateMpin(requestData);
    }
}
