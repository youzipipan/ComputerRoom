package com.example.login.service;

import net.sf.json.JSON;

public interface RoomService {

    /**
     * 查询全部教室
     */
    String queryRoom();

    /**
     * @param roomName
     * @return
     */
    JSON addRoom(String roomName);
}