package com.example.login.repository;

import com.example.login.entities.TeacherRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRoomRepository extends JpaRepository<TeacherRoom,String> {

    @Query("select t from TeacherRoom t where t.roomId=?1")
    List<TeacherRoom> findTeacherRoom(String roomId);

    TeacherRoom findByTeacherId(String id);

    @Modifying
    @Query("delete from TeacherRoom t where t.teacherId=?1")
    void deleteByTeacherId(String teacherId);
}
