package com.pvp.bank.app.bankapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Customer {

    @Id
    private @NonNull String userId;
    private String appId;
    private String mPin;
    private String customerStatus;

    private String mPinStatus;
    private String createdAt;
    private String statusUpdatedAt;
    private String mPinStatusUpdatedAt;

    private Integer mPinAttempt;
    private Integer otp;

    public Customer(String userId, String mPin) {
        this.userId = userId;
        this.mPin = mPin;
    }

    // TODO finish the coding here
    public String toSHA256() {
        return mPin;
    }
}
