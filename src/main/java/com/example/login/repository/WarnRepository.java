package com.example.login.repository;

import com.example.login.entities.Warn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarnRepository extends JpaRepository<Warn,String> {

    @Query("select w from Warn w where w.createTime = ?1")
    List<Warn> findAll(String formatDate);
}
