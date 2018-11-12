package com.example.login.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="t_computer")
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    private String id;
    @Column
    private String computerId;//计算机编号
    @Column
    private String roomId;//机房id
    @Column
    private String lockState; //锁定状态（0未锁定，1锁定中)
    @Column
    private String useState; //使用状态(0未使用，1正在使用)
    @Column
    private String lastUseState;//最后一次使用时间
    @Column
    private String temperature;//温度
    @Column
    private String cpu;//cpu使用率

}
