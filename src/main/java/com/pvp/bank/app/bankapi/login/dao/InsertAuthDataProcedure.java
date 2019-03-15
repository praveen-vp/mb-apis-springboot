package com.pvp.bank.app.bankapi.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface InsertAuthDataProcedure extends JpaRepository<LoginRepository, Long> {

    @Procedure(name = "insert_mpin_auth_details")
    String insertVerificationData(@Param("userId") String userId, @Param("appId") String appId,
                                  @Param("authType") String authType, @Param("actionFor") String actionFor);
}
