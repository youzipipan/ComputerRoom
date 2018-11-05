package com.example.login.service;

public interface ComputerService {

    /**
     * 计算机总览
     * @return
     */
    String overview();

    /**
     * 新建模拟计算机
     */
    String newlyBuild(String roomId);

    /**
     * 根据教室id查询全部计算机
     */
    String queryComputerByRoomId(String roomId);
}
