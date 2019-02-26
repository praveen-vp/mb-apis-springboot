package com.pvp.bank.app.bankapi.baseservice;

import com.pvp.bank.app.bankapi.models.BaseEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AbstractBaseService implements BaseService {

    private final @NonNull String userId;
    private final @NonNull String appId;
    private @NonNull BaseEntity requestData;

    AbstractBaseService(String userId, String appId) {
        this.userId = userId;
        this.appId = appId;
        this.requestData = new BaseEntity();
    }

    @Override
    public Boolean verifyDetails() {
        return null;
    }

    @Override
    public BaseEntity readInputDetails() {
        return null;
    }

    @Override
    public BaseEntity processDetails() {
        return null;
    }

    @Override
    public BaseEntity encryptData() {
        return null;
    }

    @Override
    public BaseEntity decryptInput() {
        return null;
    }
}
