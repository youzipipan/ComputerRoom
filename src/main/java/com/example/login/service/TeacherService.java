package com.example.login.service;

import com.example.login.entities.Teacher;

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
}
