package com.nds.ftm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nds.ftm.entity.Users;

public interface DaoUsers extends JpaRepository<Users, Object> {

    public List<Users> findAll();
}
