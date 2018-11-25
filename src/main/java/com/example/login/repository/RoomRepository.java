package com.example.login.repository;

import com.example.login.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room,String> {

    @Query("select r from Room r where r.id = ?1")
    Room findRoomById(String roomId);
}
