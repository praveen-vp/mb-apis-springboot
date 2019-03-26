package com.pvp.bank.app.bankapi.account.controllers;

import com.pvp.bank.app.bankapi.account.models.AccountInfo;
import com.pvp.bank.app.bankapi.account.service.GetAccountList;
import com.pvp.bank.app.bankapi.base.*;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AccountListController extends BaseController<AccountInfo> {

    private final GetAccountList getAccountList;

    public AccountListController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                 @NonNull ValidationService validationService,
                                 @NonNull GetAccountList getAccountList) {
        super(encryptionDecryptionService, validationService);
        this.getAccountList = getAccountList;
        this.requestData = new AccountInfo();
    }

    @Override
    public void requestHandler() {
        Set<AccountInfo> accountInfoSet = this.getAccountList.getAccountList(this.requestData.getUserId());
        JSONObject baseData = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        System.out.println(accountInfoSet);

        for (AccountInfo accountInfo : accountInfoSet) {
            jsonArray.put(accountInfo.toJson());
        }

        System.out.println(jsonArray);
        baseData.put("accountList", jsonArray);
        this.baseResponse.setResponseData(baseData.toString());
        this.requestStatus = true;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/GetAccountList")
    public BaseResponse controllerHandle(@RequestBody SecureBaseRequest baseRequest) {
        return super.process(baseRequest);
    }
}
