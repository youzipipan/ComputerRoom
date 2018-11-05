package com.example.login.repository;

import com.example.login.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer,String> {

    List<Computer> findByRoomId(String roomId);
}
