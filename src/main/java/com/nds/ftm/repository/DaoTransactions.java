package com.nds.ftm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nds.ftm.entity.Transactions;

public interface DaoTransactions extends JpaRepository<Transactions, String> {

    List<Transactions> findByAccountId(String accountId);

    @Query(value = "SELECT t.* FROM transactions AS t " +
                   "WHERE type = :type " +
                   "AND t.timestamp >= TO_DATE(:startDtm, 'YYYY-MM-DD') " +
                   "AND t.timestamp <= TO_DATE(:endDtm, 'YYYY-MM-DD') " +
                   "ORDER BY t.timestamp DESC", nativeQuery = true)
    List<Transactions> findReport(@Param("type") String type,
                                  @Param("startDtm") String startDtm, 
                                  @Param("endDtm") String endDtm);
}
