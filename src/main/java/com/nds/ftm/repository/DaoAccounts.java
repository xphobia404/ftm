package com.nds.ftm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nds.ftm.entity.Accounts;

public interface DaoAccounts extends JpaRepository<Accounts, Object> {

    List<Accounts> findByUserId(String userId);

    @Query(value = "SELECT * " +
                   "FROM accounts AS a " +
                   "WHERE a.balance > :balance ", nativeQuery = true)
    List<Accounts> searchBalance(@Param("balance") Integer balance);
    
}
