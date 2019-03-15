package com.pvp.bank.app.bankapi.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateCustomerIDProcedureCall extends JpaRepository<LoginRepository, Long> {

    @Procedure(name = "validateCustomerID")
    String executeProcedure(@Param("userId") String userId);
}
