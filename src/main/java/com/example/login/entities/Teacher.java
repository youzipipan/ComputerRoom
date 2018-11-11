package com.example.login.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    private String id;
    @Column
    private String name;  	 	//负责人姓名
    @Column
    private String phone;		//负责人电话
    @Column
    private String roomId;		//机房唯一标识
    @Column
    private String userName;		//账号
    @Column
    private String passWord;		//密码

}
