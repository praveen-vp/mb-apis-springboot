package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.InsertAuthDataProcedure;
import com.pvp.bank.app.bankapi.login.services.VerifyDCDetails;
import com.pvp.bank.app.bankapi.models.DCDetails;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyDCPinController extends BaseController<DCDetails> {

    public static final String DC_AUTH = "DC";

    @Autowired
    private final VerifyDCDetails verifyDCDetails;
    @Autowired
    private final InsertAuthDataProcedure authDataProcedure;

    public VerifyDCPinController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                 @NonNull ValidationService validationService,
                                 @NonNull VerifyDCDetails verifyDCDetails,
                                 InsertAuthDataProcedure authDataProcedure) {
        super(encryptionDecryptionService, validationService);
        this.verifyDCDetails = verifyDCDetails;
        this.authDataProcedure = authDataProcedure;
        this.requestData = new DCDetails();
    }

    @RequestMapping(value = "/VerifyDCPin", method = RequestMethod.POST)
    @Override
    public BaseResponse controllerMappingMethod(@RequestBody SecureBaseRequest baseRequest) {
        System.out.println("Request Received -- " + baseRequest);
        return super.process(baseRequest);
    }

    @Override
    public void requestHandler() throws BankException {

        this.requestStatus = this.verifyDCDetails.verifyDCPin(requestData);
        if (requestStatus) {
            authDataProcedure.insertVerificationData(requestData.getUserId(),
                    secBaseRequest.getApplicationId(), DC_AUTH, requestData.getAction());
        }
    }
}
