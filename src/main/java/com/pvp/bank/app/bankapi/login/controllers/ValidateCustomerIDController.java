package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.*;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.ValidateCustomerId;
import com.pvp.bank.app.bankapi.login.services.imp.ValidateCustomerIDService;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateCustomerIDController extends BaseController<BaseData> {

    @Autowired
    private @NonNull ValidateCustomerId validateCustomerIDService;

    public ValidateCustomerIDController(EncryptionDecryptionService encryptionDecryptionService,
                                        ValidationService validationService,
                                        ValidateCustomerIDService validateCustomerIDService) {
        super(encryptionDecryptionService, validationService);
        this.validateCustomerIDService = validateCustomerIDService;
        this.requestData = new BaseData();
    }

    /**
     * Added for the request mapping purpose alone
     *
     * @param request
     * @return @{@link BaseResponse} with the details of the provided customer id
     * @throws Exception
     */
    @RequestMapping(value = "/ValidateCustomerId",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public BaseResponse controllerHandle(@RequestBody SecureBaseRequest request) {
        System.out.println("Request Received -- " + request);
        return super.process(request);
    }

    @Override
    public void requestHandler() throws BankException {
        this.requestStatus = this.validateCustomerIDService.validateCustomerID(requestData.getUserId());
    }
}
