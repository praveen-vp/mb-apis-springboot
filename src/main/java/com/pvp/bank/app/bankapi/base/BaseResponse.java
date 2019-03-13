package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.helper.Utils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.security.NoSuchAlgorithmException;

@ToString
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class BaseResponse extends BaseModel {

    private String errorCode;
    private String errorDesc = "SUCCESS";
    private String appId;
    private BaseData data;

    public BaseResponse(SecureBaseRequest secBaseRequest) throws NoSuchAlgorithmException {
        this.errorCode = Appconstants.SUCCESS;
        this.appId = secBaseRequest.getApplicationId();
        setMsgId(Utils.generateReqId(secBaseRequest.getReqTime() + this.appId + secBaseRequest.getEncData()));
        secBaseRequest.setMsgId(this.getMsgId());
    }
}
