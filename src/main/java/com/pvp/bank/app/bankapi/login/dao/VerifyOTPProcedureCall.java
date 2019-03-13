package com.pvp.bank.app.bankapi.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyOTPProcedureCall extends JpaRepository<LoginDBCall, Long> {

    @Procedure(name = "verifyOTP")
    String executeProcedure(@Param("userId") String userId, @Param("applicationId") String mPin,
                            @Param("otp") Integer otp);
}
