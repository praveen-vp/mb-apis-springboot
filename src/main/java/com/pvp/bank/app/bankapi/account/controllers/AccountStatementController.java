package com.pvp.bank.app.bankapi.account.controllers;

import com.pvp.bank.app.bankapi.account.models.AccountStatementObj;
import com.pvp.bank.app.bankapi.account.models.TransactionHistoryObj;
import com.pvp.bank.app.bankapi.account.serviceimp.AccountStatementService;
import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AccountStatementController extends BaseController<AccountStatementObj> {

    @Autowired
    private final AccountStatementService accountStatementService;

    public AccountStatementController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                      @NonNull ValidationService validationService,
                                      @NonNull AccountStatementService accountStatementService) {
        super(encryptionDecryptionService, validationService);
        this.accountStatementService = accountStatementService;
        this.requestData = new AccountStatementObj();
    }

    @Override
    public void requestHandler() throws BankException {
        Set<TransactionHistoryObj> transactionHistoryObjSet = this.accountStatementService.getStatement(this.requestData);

        JSONObject baseData = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (TransactionHistoryObj historyObj : transactionHistoryObjSet) {
            jsonArray.put(historyObj.toJson());
        }

        System.out.println(jsonArray);
        baseData.put("transactions", jsonArray);
        this.baseResponse.setResponseData(baseData.toString());
        this.requestStatus = true;
    }

    @Override
    @RequestMapping(value = "/GetStatement", method = RequestMethod.POST)
    public BaseResponse controllerMappingMethod(@RequestBody SecureBaseRequest baseRequest) {
        System.out.println(baseRequest);
        return super.process(baseRequest);
    }
}
