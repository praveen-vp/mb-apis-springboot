package com.pvp.bank.app.bankapi.base;

import com.pvp.bank.app.bankapi.appconstants.Appconstants;
import com.pvp.bank.app.bankapi.helper.Utils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Data
@EqualsAndHashCode
@SuperBuilder
public class BaseResponse extends BaseModel {

    private String errorCode;
    private String errorDesc;
    private String appId;
    private String requestId;
    private BaseData data;

    public BaseResponse(BaseRequest baseRequest) throws Exception {
        this.errorCode = Appconstants.SUCCESS;
        this.appId = baseRequest.getAppId();
        this.requestId = Utils.getSHA1_diget(baseRequest.getReqTime() + this.appId);
        this.data = baseRequest.getData();
    }
}
