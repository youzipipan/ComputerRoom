package com.example.login.service;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public interface RoomService {

    /**
     * 查询全部教室
     */
    String queryRoom();

    /**
     * @param roomName
     * @return
     */
    JSONObject addRoom(String roomName);

    String deleteRoom(String id);
}