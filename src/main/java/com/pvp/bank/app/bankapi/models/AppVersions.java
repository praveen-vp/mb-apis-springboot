package com.pvp.bank.app.bankapi.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "app_version_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppVersions extends BaseEntity {

    @Column(name = "appid")
    private @NonNull String appId;

    @Column(name = "app_version")
    private @NonNull String appVersion;

    @Column(name = "created_at")
    private @NonNull Timestamp createdAt;

}
