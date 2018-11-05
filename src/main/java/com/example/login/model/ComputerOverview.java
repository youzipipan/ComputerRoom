package com.example.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerOverview {

//    计算机总数量
    private String computerCount;

//    正在使用的计算机数量
    private String useCount;

//    当天警告数量
    private String warnCount;

//    当前故障计算机数量
    private String badCount;

}
