package com.example.login.service.impl;

import com.example.login.entities.*;
import com.example.login.repository.*;
import com.example.login.service.WarnService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WarnServiceImpl implements WarnService {

    @Resource
    private WarnRepository warnRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @Resource
    private TeacherRoomRepository teacherRoomRepository;

    @Resource
    private ComputerRepository computerRepository;

    /**
     * 待处理的警报
     * @return
     */
    @Transactional
    @Override
    public String toBeProcessed() {

        List<Warn> warnList = warnRepository.findByToState("0");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "成功");
        jsonObject.put("count",warnList.size());
        jsonObject.put("data",warnList);
        return jsonObject.toString();
    }

    /**
     * 已处理的警报
     * @return
     */
    @Transactional
    @Override
    public String processed() {

        List<Warn> warnList = warnRepository.findProcessed();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "成功");
        jsonObject.put("count",warnList.size());
        jsonObject.put("data",warnList);
        return jsonObject.toString();
    }

    /**
     * 自动处理的警报
     * @return
     */
    @Transactional
    @Override
    public String automaticProcessing() {

        List<Warn> warnList = warnRepository.findByToState("2");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "成功");
        jsonObject.put("count",warnList.size());
        jsonObject.put("data",warnList);
        return jsonObject.toString();
    }

    /**
     * 处理警报
     * @param id
     * @param comId
     * @return
     */
    @Transactional
    @Override
    public String handle(String id, String comId) {

        warnRepository.update(id);
        Computer computer = computerRepository.findByComputerId(comId);
        List<TeacherRoom> teacherRoom = teacherRoomRepository.findTeacherRoom(computer.getRoomId());
        Teacher teacher = teacherRepository.findTeacherById(teacherRoom.get(0).getTeacherId());
        Teacher teacher1 = new Teacher();
        teacher1.setName(teacher.getName());
        teacher1.setPhone(teacher.getPhone());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "处理成功");
        jsonObject.put("data",teacher);
        return jsonObject.toString();
    }
}
