package com.pvp.bank.app.bankapi.login.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "verifyMpin",
                procedureName = "pkg_login.verifyMpin",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mPin", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "generateMpin",
                procedureName = "pkg_login.generateMpin",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mPin", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "validateCustomerID",
                procedureName = "pkg_login.validateCustomerID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "generateOTP",
                procedureName = "pkg_login.generateOTP",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "appId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "otp", type = Integer.class)
                }),
        @NamedStoredProcedureQuery(name = "verifyOTP",
                procedureName = "pkg_login.verifyOTP",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "appId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "otp", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "insert_mpin_auth_details",
                procedureName = "pkg_login.insert_mpin_auth_details",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "appId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "authType", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionFor", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                })
})
public class LoginRepository implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
