package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseData;
import com.pvp.bank.app.bankapi.base.BaseRequest;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.imp.ValidateCustomerIDService;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCustomerIDController extends BaseController {

    @Autowired
    private final ValidateCustomerIDService validateCustomerIDService;

    public ValidateCustomerIDController(EncryptionDecryptionService encryptionDecryptionService,
                                        ValidateCustomerIDService validateCustomerIDService) {
        super(encryptionDecryptionService);
        this.validateCustomerIDService = validateCustomerIDService;
    }

    @RequestMapping("/ValidateCustomerId")
    public BaseResponse validateCustomerId(BaseRequest request) {

        this.requestStatus = false;

        try {
            BaseData requestData = super.decryptRequest(request);
            this.requestStatus = this.validateCustomerIDService.validateCustomerID(requestData.getUserId());
        } catch (BankException e) {
            this.baseResponse.setErrorCode(e.getErrorDesc());
            this.baseResponse.setErrorCode(e.getErrorCode());
        }

        if (requestStatus) {
            super.encryptResponse(baseResponse);
        }

        return this.baseResponse;
    }
}
