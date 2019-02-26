package com.pvp.bank.app.bankapi.baseserviceimp;

import com.pvp.bank.app.bankapi.baseservice.AppIdService;

public class AppIdServiceImp implements AppIdService {

    private final String appId;

    public AppIdServiceImp(String appId) {
        this.appId = appId;
    }

    @Override
    public Boolean verifyAppId() {
        return null;
    }
}
