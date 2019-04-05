package com.example.login.service.impl;

import com.example.login.entities.Room;
import com.example.login.repository.RoomRepository;
import com.example.login.repository.TeacherRoomRepository;
import com.example.login.service.RoomService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomRepository roomRepository;
    @Resource
    private TeacherRoomRepository teacherRoomRepository;

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

    /**
     * 新增教室
     * @param roomName
     * @return
     */
    @Transactional
    @Override
    public JSONObject addRoom(String roomName) {

        Room room = new Room();
        room.setId(UUID.randomUUID().toString().replaceAll("-",""));
        room.setName(roomName);
        roomRepository.save(room);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","新增成功");
        return jsonObject;
    }

    /**
     * 删除机房
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String deleteRoom(String id) {

        teacherRoomRepository.deleteByRoomId(id);
        roomRepository.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "删除成功");
        return jsonObject.toString();
    }

}
