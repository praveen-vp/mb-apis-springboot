package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Component
public class BaseController {

    protected Boolean requestStatus = false;
    protected BaseData requestData;
    protected BaseRequest baseRequest;
    protected BaseResponse baseResponse;

    @Autowired
    private EncryptionDecryptionService encryptionDecryptionService;

    public BaseController(EncryptionDecryptionService encryptionDecryptionService) {
        this.encryptionDecryptionService = encryptionDecryptionService;
        this.baseRequest = BaseRequest.builder().build();
        this.baseResponse = BaseResponse.builder().appId(baseRequest.getAppId()).build();
    }

    protected BaseData decryptRequest(BaseRequest request) {
        return encryptionDecryptionService.decryptRequest(request.getData().toString());
    }

    protected String encryptResponse(BaseResponse response) {
        return this.encryptionDecryptionService.encryptResponse(response.toString());
    }
}
