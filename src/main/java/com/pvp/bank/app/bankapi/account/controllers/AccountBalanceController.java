package com.pvp.bank.app.bankapi.account.controllers;

import com.pvp.bank.app.bankapi.account.models.AccountBalanceInfo;
import com.pvp.bank.app.bankapi.account.service.GetBalance;
import com.pvp.bank.app.bankapi.base.BaseController;
import com.pvp.bank.app.bankapi.base.BaseResponse;
import com.pvp.bank.app.bankapi.base.SecureBaseRequest;
import com.pvp.bank.app.bankapi.base.ValidationService;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountBalanceController extends BaseController<AccountBalanceInfo> {

    private final @NonNull GetBalance getBalance;

    public AccountBalanceController(@NonNull EncryptionDecryptionService encryptionDecryptionService,
                                    @NonNull ValidationService validationService,
                                    @NonNull GetBalance getBalance) {
        super(encryptionDecryptionService, validationService);
        this.getBalance = getBalance;
        this.requestData = new AccountBalanceInfo();
    }

    @Override
    public void requestHandler() throws BankException {
        this.requestData.setAvailableBalance(this.getBalance.getAvailableBalance
                (this.requestData.getAccountNumber()));
        this.requestData.setEffectiveBalance(this.getBalance.getEffectiveBalance
                (this.requestData.getAccountNumber()));
        this.baseResponse.setResponseData(this.requestData.toJson().toString());
        this.requestStatus = true;
    }

    @Override
    @RequestMapping(value = "/GetBalance", method = RequestMethod.POST)
    public BaseResponse controllerMappingMethod(@RequestBody SecureBaseRequest baseRequest) {
        return super.process(baseRequest);
    }
}
