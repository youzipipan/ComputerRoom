package com.example.login.repository;

import com.example.login.entities.Warn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarnRepository extends JpaRepository<Warn,String> {

    @Query("select w from Warn w where w.createTime = ?1")
    List<Warn> findAll(String formatDate);

    @Query("select w from Warn w where w.doState = ?1")
    List<Warn> findByToState(String doState);

    @Query("select w from Warn w where w.doState = '1' or w.doState = '2'")
    List<Warn> findProcessed();

    @Modifying
    @Query("update Warn w set w.doState = '1' where w.id = ?1")
    void update(String id);

    @Query("select w from Warn w where w.id=?1")
    Warn findWarnById(String id);
}
