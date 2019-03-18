package com.pvp.bank.app.bankapi.login.httpapi;

import com.pvp.bank.app.bankapi.httpapi.HttpApi;
import com.pvp.bank.app.bankapi.models.HttpReqModel;
import com.pvp.bank.app.bankapi.models.HttpRespModel;
import com.pvp.bank.app.bankapi.models.NBPasswordModel;
import lombok.Data;

@Data
public class NBPasswordAPIService extends HttpApi<HttpRespModel> {

    public NBPasswordAPIService(HttpReqModel httpReqModel) {
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
