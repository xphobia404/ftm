package com.nds.ftm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nds.ftm.entity.Accounts;

public interface DaoAccounts extends JpaRepository<Accounts, Object> {

    List<Accounts> findByUserId(String userId);
}
