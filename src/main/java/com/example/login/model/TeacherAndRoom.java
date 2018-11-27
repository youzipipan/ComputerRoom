package com.example.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAndRoom {

    @Id
    private String id;
    @Column
    private String name;  	 	//负责人姓名
    @Column
    private String phone;		//负责人电话
    @Column
    private String roomName;		//机房名称
    @Column
    private String userName;		//账号
    @Column
    private String passWord;		//密码
}
