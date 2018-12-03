package com.example.login.repository;

import com.example.login.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Modifying
    @Query("update Teacher t set t.name=?1 ,t.phone=?2 ,t.userName=?3 ,t.passWord=?4 ,t.roomId=?5 where t.id=?6")
    void updateTeacher(String name, String phone, String userName, String passWord, String roomId, String id);

    @Query("select t from Teacher t where t.userName=?1 and t.passWord=?2")
    Teacher findTeacher(String userName, String passWord);

    @Query("select t from Teacher t where t.id=?1")
    Teacher findTeacherById(String teacherId);

    @Query("select t from Teacher t where t.userName=?1 and t.passWord=?2")
    Teacher findByUAndP(String userName, String passWord);

    @Modifying
    @Query("update Teacher t set t.passWord=?1 where t.passWord=?2 and t.userName=?3")
    void updateByUAndP(String passWordH, String passWordY, String userName);
}
