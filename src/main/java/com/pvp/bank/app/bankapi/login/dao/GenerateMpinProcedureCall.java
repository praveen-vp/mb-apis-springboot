package com.pvp.bank.app.bankapi.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerateMpinProcedureCall extends JpaRepository<LoginDBCall, Long> {

    @Procedure(name = "generateMpin")
    String executeProcedure(@Param("userId") String userId, @Param("mPin") String mPin);
}
