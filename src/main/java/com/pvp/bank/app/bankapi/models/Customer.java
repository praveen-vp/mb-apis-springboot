package com.pvp.bank.app.bankapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    private final @NonNull String userId;
    private @NonNull String appId;
    private String mpin;
    private String customerStatus;

    private String mpinStatus;
    private String createdAt;
    private String statusUpdatedAt;
    private String mpinStatusUpdatedAt;

    private Integer mpinAttempt;

}
