package com.example.login.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="t_room")
public class Room {

    @Id
    private String id;//唯一主键
    @Column
    private String name; //机房名

}
