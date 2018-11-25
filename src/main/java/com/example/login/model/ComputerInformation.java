package com.example.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerInformation {

    private String id;
    private String computerId;//计算机编号
    private String roomId;//机房id
    private String lockState; //锁定状态（0未锁定，1锁定中)
    private String useState; //使用状态(0未使用，1正在使用)
    private String lastUseState;//最后一次使用时间
    private String temperature;//温度
    private String cpu;//cpu使用率
    private String room;
}
