package com.example.login.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="t_room")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private String id;//唯一主键
    @Column
    private String name; //机房名

}
