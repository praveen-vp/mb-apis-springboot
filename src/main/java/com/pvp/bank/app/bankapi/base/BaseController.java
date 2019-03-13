package com.pvp.bank.app.bankapi.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.exceptions.BankException;
import com.pvp.bank.app.bankapi.security.EncryptionDecryptionService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Component
@RequiredArgsConstructor
public abstract class BaseController<T extends BaseData> {

    protected Boolean requestStatus = false;
    protected T requestData; // initialize in child class constructor.
    protected SecureBaseRequest secBaseRequest;
    protected BaseResponse baseResponse;

    @Autowired
    protected @NonNull EncryptionDecryptionService encryptionDecryptionService;
    @Autowired
    protected @NonNull ValidationService validationService;

    protected BaseResponse process(SecureBaseRequest request) {

        try {

            initialiseReqResp(request);
            this.requestStatus = false;
            System.out.println(this.requestData);
            this.requestData = castObject(requestData.getClass(), decryptRequest(request));
            System.out.println(" request data --- " + requestData);

            if (validationService.validate(request)) {
                requestHandler();
            } else {
                throw new BankException(Appconstants.FAILED);
            }
        } catch (BankException e) {
            this.baseResponse.setErrorCode(e.getErrorDesc());
            this.baseResponse.setErrorCode(e.getErrorCode());
        } catch (Exception e1) {
            e1.printStackTrace();
            this.baseResponse.setErrorDesc(e1.getLocalizedMessage());
            this.baseResponse.setErrorCode(Appconstants.FAILED);
        }

        if (requestStatus) {
            encryptResponse(baseResponse);
        }

        this.baseResponse.setRespTime(System.currentTimeMillis());
        return this.baseResponse;
    }

    /**
     * The method which processes all the request related operations.
     * This will be implemented in the sub classes.
     *
     * @throws BankException
     */
    public abstract void requestHandler() throws BankException;

    protected String decryptRequest(SecureBaseRequest request) throws BankException {
        System.out.println(" Base Controller SecBaseRequest Received before encryption --- " + request);
        return encryptionDecryptionService.decryptRequest(request.getEncData());
    }

    protected String encryptResponse(BaseResponse response) {
        return this.encryptionDecryptionService.encryptResponse(response.toString());
    }

    public void initialiseReqResp(SecureBaseRequest secBaseRequest) throws NoSuchAlgorithmException {
        System.out.println(this.getClass() + " initialising the request and response" + secBaseRequest);
        this.secBaseRequest = secBaseRequest;
        this.baseResponse = new BaseResponse(secBaseRequest);
    }

    protected T castObject(Class clazz, String decryptedString) throws BankException {
        try {
            System.out.println(this.getClass() + " BaseController decrypted String -- " + decryptedString);
            return new ObjectMapper().readerFor(clazz).readValue(decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BankException(Appconstants.OBJECT_MAPPING_FAILED);
        }
    }
}
