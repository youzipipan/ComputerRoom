package com.example.login.service.impl;

import com.example.login.entities.Room;
import com.example.login.entities.Teacher;
import com.example.login.entities.TeacherRoom;
import com.example.login.model.TeacherAndRoom;
import com.example.login.repository.RoomRepository;
import com.example.login.repository.TeacherRepository;
import com.example.login.repository.TeacherRoomRepository;
import com.example.login.service.TeacherService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    @Resource
    private TeacherRoomRepository teacherRoomRepository;

    @Resource
    private RoomRepository roomRepository;

    /**
     * 添加负责人
     *
     * @param teacher
     * @return
     */
    @Transactional
    @Override
    public String addTeacher(Teacher teacher) {

        teacher.setId(UUID.randomUUID().toString());
        teacherRepository.save(teacher);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "添加成功");
        return jsonObject.toString();
    }

    /**
     * 修改负责人信息
     *
     * @param teacher
     * @return
     */
    @Transactional
    @Override
    public String modifyTeacher(Teacher teacher) {

        teacherRepository.updateTeacher(teacher.getName(), teacher.getPhone(), teacher.getUserName(), teacher.getPassWord(), teacher.getRoomId(), teacher.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "修改成功");
        return jsonObject.toString();
    }

    /**
     * 查看负责人信息
     *
     * @return
     */
    @Transactional
    @Override
    public String queryTeacher() {

        List<Teacher> teacherList = teacherRepository.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "添加成功");
        jsonObject.put("data", teacherList);
        return jsonObject.toString();
    }

    /**
     * 删除负责人
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String deleteTeacher(String id) {

        teacherRepository.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "删除成功");
        return jsonObject.toString();
    }

    /**
     * 权限
     *
     * @param teacherId
     * @param roomId
     * @return
     */
    @Transactional
    @Override
    public JSON power(String teacherId, String roomId) {

        List<TeacherRoom> teacherRoomList = teacherRoomRepository.findTeacherRoom(roomId);
        if (!teacherRoomList.isEmpty() && teacherRoomList.size() > 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state", "1");
            jsonObject.put("msg", "该教室已有负责人！！！");
            return jsonObject;
        } else {
            TeacherRoom teacherRoom = new TeacherRoom();
            teacherRoom.setId(UUID.randomUUID().toString().replace("-",""));
            teacherRoom.setRoomId(roomId);
            teacherRoom.setTeacherId(teacherId);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state", "0");
            jsonObject.put("msg", "授权成功！");
            return jsonObject;
        }
    }

    /**
     * 查询负责人
     * @return
     */
    @Transactional
    @Override
    public JSON findTeacher() {

        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherAndRoom> teacherAndRooms = new ArrayList<>();
        teacherList.forEach(e ->{
            TeacherRoom teacherRoom = teacherRoomRepository.findByTeacherId(e.getId());
            Room room = roomRepository.findRoomById(teacherRoom.getRoomId());
            TeacherAndRoom teacherAndRoom = new TeacherAndRoom();
            teacherAndRoom.setId(e.getId());
            teacherAndRoom.setName(e.getName());
            teacherAndRoom.setPhone(e.getPhone());
            teacherAndRoom.setUserName(e.getUserName());
            teacherAndRoom.setPassWord(e.getPassWord());
            teacherAndRoom.setRoomName(room.getName());
            teacherAndRooms.add(teacherAndRoom);
        });
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "查询成功！");
        jsonObject.put("data", teacherAndRooms);
        return jsonObject;
    }
}
