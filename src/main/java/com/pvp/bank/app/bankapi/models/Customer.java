package com.pvp.bank.app.bankapi.models;

import com.pvp.bank.app.bankapi.base.BaseData;
import com.pvp.bank.app.bankapi.helper.Utils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "customer_info")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseData {

    private String appId;
    private String mPin;
    private String customerStatus;

    private String mPinStatus;
    private String createdAt;
    private String statusUpdatedAt;
    private String mPinStatusUpdatedAt;

    private Integer mPinAttempt;
    private Integer otp;
    private Integer mobile;

    public Customer(String userId, String mPin) throws NoSuchAlgorithmException {
        super(userId);
        this.mPin = mPin;
        this.mPin = mpinToSHA256();
    }

    @Builder(builderMethodName = "CustomerBuilder")
    public Customer(String userId, String appId, String mPin, String customerStatus, String mPinStatus, String createdAt, String statusUpdatedAt, String mPinStatusUpdatedAt, Integer mPinAttempt, Integer otp) {
        super(userId);
        this.appId = appId;
        this.mPin = mPin;
        this.customerStatus = customerStatus;
        this.mPinStatus = mPinStatus;
        this.createdAt = createdAt;
        this.statusUpdatedAt = statusUpdatedAt;
        this.mPinStatusUpdatedAt = mPinStatusUpdatedAt;
        this.mPinAttempt = mPinAttempt;
        this.otp = otp;
    }

    public String mpinToSHA256() throws NoSuchAlgorithmException {
        this.mPin = Utils.get_SHA_SecurePassword(mPin, Utils.SHA512);
        return mPin;
    }
}
