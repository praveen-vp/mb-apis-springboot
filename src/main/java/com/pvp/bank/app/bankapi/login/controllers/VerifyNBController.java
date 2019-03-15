package com.pvp.bank.app.bankapi.login.controllers;

import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.login.dao.InsertAuthDataProcedure;
import com.pvp.bank.app.bankapi.login.services.VerifyNBDetails;
import com.pvp.bank.app.bankapi.models.NBPasswordModel;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyNBController extends BaseController<NBPasswordModel> {

    public static final String NB_AUTH = "NB";
    private final VerifyNBDetails verifyNBDetails;
    private final InsertAuthDataProcedure insertAuthData;

    public VerifyNBController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                              @NonNull ValidationService validationService,
                              @NonNull VerifyNBDetails verifyNBDetails,
                              @NonNull InsertAuthDataProcedure insertAuthData) {
        super(encryptionDecryptionService, validationService);
        this.verifyNBDetails = verifyNBDetails;
        this.insertAuthData = insertAuthData;
        this.requestData = new NBPasswordModel();
    }

    @Override
    @RequestMapping(value = "/VerifyNBPassword", method = RequestMethod.POST)
    public BaseResponse controllerHandle(SecureBaseRequest baseRequest) {
        System.out.println(" request received -- " + baseRequest);
        return super.process(baseRequest);
    }

    @Override
    public void requestHandler() throws BankException {

        this.requestStatus = verifyNBDetails.verifyNBPassword(requestData.getUserId(),
                requestData.getPassword());

        if (this.requestStatus)
            insertAuthData.insertVerificationData(requestData.getUserId(),
                    secBaseRequest.getApplicationId(),
                    NB_AUTH, requestData.getActionFor());
    }
}

