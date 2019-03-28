package com.pvp.bank.app.bankapi.account.dao;

import com.pvp.bank.app.bankapi.account.models.TransactionHistoryObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface AccountStatementRepository extends JpaRepository<TransactionHistoryObj, Long> {

    @Query(value = "select amount, reference_number, TO_char(CREATED_DATE) as created_date," +
            " description from transaction_history " +
            " where account_Number = :accountNumber and user_Id = :userId and " +
            " (" +
            "   created_Date BETWEEN TO_DATE(:startDate, 'yyyy/mm/dd') AND TO_DATE(:endDate, 'yyyy/mm/dd')" +
            " )"
    , nativeQuery = true)
    Set<TransactionHistoryObj> getTransactionHistory(@Param("startDate") String startDate,
                                                     @Param("endDate") String endDate,
                                                     @Param("userId") String userId,
                                                     @Param("accountNumber") String accountNumber);
}
