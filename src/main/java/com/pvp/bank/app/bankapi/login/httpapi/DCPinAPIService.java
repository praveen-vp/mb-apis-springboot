package com.pvp.bank.app.bankapi.login.httpapi;

import com.pvp.bank.app.bankapi.httpapi.HttpApi;
import com.pvp.bank.app.bankapi.models.HttpReqModel;
import com.pvp.bank.app.bankapi.models.HttpRespModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class DCPinAPIService extends HttpApi<HttpRespModel> {

    public DCPinAPIService(HttpReqModel httpReqModel) {
        super(httpReqModel);
    }

    @Override
    public String createRequest() {
        return null;
    }

    @Override
    public void addHeaders() {

    }

    @Override
    public HttpRespModel parseResponse(String response) {
        return null;
    }
}
