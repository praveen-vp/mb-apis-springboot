package com.pvp.bank.app.bankapi.login.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "verifympin",
                procedureName = "pkg_login_verifympin",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mPin", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "verifyOTP",
                procedureName = "pkg_login_verifyOTP",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "appId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "otp", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "generateMpin",
                procedureName = "pkg_login_generateMpin",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "mpin", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "validateCustomerID",
                procedureName = "pkg_login_validateCustomerID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responseCode", type = String.class)
                })
})
public class LoginDBCall implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
