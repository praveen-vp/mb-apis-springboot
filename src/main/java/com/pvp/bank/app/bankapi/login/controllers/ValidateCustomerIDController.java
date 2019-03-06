package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseRequest;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.services.imp.ValidateCustomerIDService;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCustomerIDController extends BaseController {

    private final ValidateCustomerIDService validateCustomerIDService;

    public ValidateCustomerIDController(EncryptionDecryptionService encryptionDecryptionService,
                                        ValidationService validationService,
                                        ValidateCustomerIDService validateCustomerIDService) {
        super(encryptionDecryptionService, validationService);
        this.validateCustomerIDService = validateCustomerIDService;
    }

    /**
     * Added for the request mapping purpose alone
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/ValidateCustomerId")
    public BaseResponse validateCustomerId(BaseRequest request) throws Exception {
        return super.process(request);
    }

    @Override
    public void requestHandler() throws BankException {
        this.requestStatus = this.validateCustomerIDService.validateCustomerID(requestData.getUserId());
    }
}
