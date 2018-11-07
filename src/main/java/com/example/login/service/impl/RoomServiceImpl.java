package com.example.login.service.impl;

import com.example.login.entities.Room;
import com.example.login.repository.RoomRepository;
import com.example.login.service.RoomService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomRepository roomRepository;

    /**
     * 查询全部教室
     * @return
     */
    @Transactional
    @Override
    public String queryRoom() {

        List<Room> rooms = roomRepository.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","查询成功");
        jsonObject.put("data",rooms);
        return jsonObject.toString();
    }
}
