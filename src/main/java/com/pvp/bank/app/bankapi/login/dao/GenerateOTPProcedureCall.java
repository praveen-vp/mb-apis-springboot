package com.pvp.bank.app.bankapi.login.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface GenerateOTPProcedureCall extends JpaRepository<LoginDBCall, Long> {

    @Procedure(name = "generateOTP")
    Integer generateOtp(@Param("userId") String userId, @Param("appId") String appId);
}
