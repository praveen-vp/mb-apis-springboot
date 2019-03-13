package com.pvp.bank.app.bankapi.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@ToString
@Getter
@Setter
public class SecureBaseRequest extends BaseModel {

    private @NonNull String encData;
    private @NonNull String applicationId;

    public SecureBaseRequest() {
    }

    public SecureBaseRequest(String appId, String eData) {
        this.applicationId = appId;
        this.encData = eData;
    }
}
