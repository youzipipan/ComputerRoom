package com.example.login.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_teacherRoom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRoom {

    @Id
    private String id;
    @Column
    private String roomId;
    @Column
    private String teacherId;

}
