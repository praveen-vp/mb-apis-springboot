package com.pvp.bank.app.bankapi.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Component
@RequiredArgsConstructor
public abstract class BaseController {

    protected Boolean requestStatus = false;
    protected BaseData requestData;
    protected BaseRequest baseRequest;
    protected BaseResponse baseResponse;

    @Autowired
    protected @NonNull EncryptionDecryptionService encryptionDecryptionService;
    @Autowired
    protected @NonNull ValidationService validationService;

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

    /**
     * The method which processes all the request related operations.
     * This will be implemented in the sub classes.
     *
     * @throws BankException
     */
    public abstract void requestHandler() throws BankException;

    /**
     * This method is required to get the proper object as per the request.
     *
     * @param decryptedString
     * @return
     * @throws BankException
     */
    public BaseData typeCastRequestData(String decryptedString) throws BankException {
        try {
            System.out.println(" BaseController decrypted String -- " + decryptedString);
            return new ObjectMapper().readerFor(BaseData.class).readValue(decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BankException(Appconstants.OBJECT_MAPPING_FAILED);
        }
    }

    protected BaseData decryptRequest(BaseRequest request) throws BankException {
        System.out.println(" Base Controller BaseRequest Recieved --- " + request);
        return typeCastRequestData(encryptionDecryptionService.decryptRequest(request.getEData()));
    }

    protected String encryptResponse(BaseResponse response) {
        return this.encryptionDecryptionService.encryptResponse(response.toString());
    }

    public void initialiseReqResp(BaseRequest baseRequest) throws Exception {
        this.baseRequest = baseRequest;
        this.baseResponse = new BaseResponse(baseRequest);
    }
}
