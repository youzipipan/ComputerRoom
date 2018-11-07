package com.example.login.service.impl;

import com.example.login.entities.Teacher;
import com.example.login.repository.TeacherRepository;
import com.example.login.service.TeacherService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    /**
     * 添加负责人
     * @param teacher
     * @return
     */
    @Transactional
    @Override
    public String addTeacher(Teacher teacher) {

        teacher.setId(UUID.randomUUID().toString());
        teacherRepository.save(teacher);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","添加成功");
        return jsonObject.toString();
    }

    /**
     * 修改负责人信息
     * @param teacher
     * @return
     */
    @Transactional
    @Override
    public String modifyTeacher(Teacher teacher) {

        teacherRepository.updateTeacher(teacher.getName(),teacher.getPhone(),teacher.getUserName(),teacher.getPassWord(),teacher.getRoomId(),teacher.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","修改成功");
        return jsonObject.toString();
    }

    /**
     * 查看负责人信息
     * @return
     */
    @Transactional
    @Override
    public String queryTeacher() {

        List<Teacher> teacherList = teacherRepository.findAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","添加成功");
        jsonObject.put("data",teacherList);
        return jsonObject.toString();
    }

    /**
     * 删除负责人
     * @param id
     * @return
     */
    @Override
    public String deleteTeacher(String id) {

        teacherRepository.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","删除成功");
        return jsonObject.toString();
    }
}
