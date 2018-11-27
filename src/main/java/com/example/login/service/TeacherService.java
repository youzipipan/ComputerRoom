package com.example.login.service;

import com.example.login.entities.Teacher;
import net.sf.json.JSON;

public interface TeacherService {

    /**
     * 添加负责人
     * @param teacher
     * @return
     */
    String addTeacher (Teacher teacher);

    /**
     * 修改负责人信息
     * @param teacher
     * @return
     */
    String modifyTeacher (Teacher teacher);

    /**
     * 查看负责人信息
     * @return
     */
    String queryTeacher ();

    /**
     * 删除负责人
     * @param id
     * @return
     */
    String deleteTeacher (String id);

    /**
     * 权限
     * @param teacherId
     * @param roomId
     * @return
     */
    JSON power (String teacherId , String roomId);

    /**
     * 查询所有负责人
     * @return
     */
    JSON findTeacher();
}
