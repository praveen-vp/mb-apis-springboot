package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
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
public abstract class BaseController {

    protected Boolean requestStatus = false;
    protected BaseData requestData;
    protected BaseRequest baseRequest;
    protected BaseResponse baseResponse;

    @Autowired
    private EncryptionDecryptionService encryptionDecryptionService;

    @Autowired
    private ValidationService validationService;

    public BaseController(EncryptionDecryptionService encryptionDecryptionService, ValidationService validationService) {
        this.encryptionDecryptionService = encryptionDecryptionService;
        this.validationService = validationService;
    }

    /**
     * The method which processes all the request related operations.
     * This will be implemented in the sub classes.
     *
     * @throws BankException
     */
    public abstract void requestHandler() throws BankException;

    protected BaseData decryptRequest(BaseRequest request) {
        // TODO proper implementation is required
        return encryptionDecryptionService.decryptRequest(request.getData().toString());
    }

    protected String encryptResponse(BaseResponse response) {
        return this.encryptionDecryptionService.encryptResponse(response.toString());
    }

    public void initialiseReqResp(BaseRequest baseRequest) throws Exception {
        this.baseRequest = baseRequest;
        this.baseResponse = new BaseResponse(baseRequest);
    }

    protected BaseResponse process(BaseRequest request) throws Exception {

        initialiseReqResp(request);
        this.requestStatus = false;

        try {
            this.requestData = decryptRequest(request);
            if (validationService.validate(request)) {
                requestHandler();
            } else {
                throw new BankException(Appconstants.FAILED);
            }
        } catch (BankException e) {
            this.baseResponse.setErrorCode(e.getErrorDesc());
            this.baseResponse.setErrorCode(e.getErrorCode());
        }

        if (requestStatus) {
            encryptResponse(baseResponse);
        }

        return this.baseResponse;
    }
}
