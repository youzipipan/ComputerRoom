package com.example.login.repository;

import com.example.login.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, String> {

    List<Computer> findByRoomId(String roomId);

    Computer findByComputerId(String computerId);

    @Modifying
    @Query("update Computer c set c.useState='1' ,c.lastUseState=null where c.id=?1")
    void update0(String id);

    @Modifying
    @Query("update Computer c set c.useState='0' ,c.lastUseState=?2 where c.id=?1")
    void update1(String id, String date);

    @Modifying
    @Query("update Computer c set c.useState='1' ,c.lastUseState=null")
    void update2();

    @Modifying
    @Query("update Computer c set c.useState='0' ,c.lastUseState=?1")
    void upfate3(String date);

    @Modifying
    @Query("update Computer c set c.lockState='1' where c.id=?1")
    void updateLock(String id);

    @Modifying
    @Query("update Computer c set c.lockState='0' where c.id=?1")
    void updateUnlock(String id);

    @Query("select c from Computer c where c.id = ?1 ")
    Computer findComputerById(String id);
}
