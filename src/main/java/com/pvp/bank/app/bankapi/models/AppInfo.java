package com.pvp.bank.app.bankapi.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "app_info")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppInfo extends BaseEntity {

    @Column(name = "appid")
    private @NonNull String appId;

    @Column(name = "os_version")
    private @NonNull String osVersion;

    @Column(name = "os")
    private @NonNull String os;

    @Column(name = "os_vendor")
    private String osVendor;

    @Column(name = "imei")
    private @NonNull String imei;

    @Column(name = "model")
    private @NonNull String model;

    @Column(name = "vendor")
    private @NonNull String vendor;

    @Column(name = "created_at")
    private @NonNull String createdAt;
}