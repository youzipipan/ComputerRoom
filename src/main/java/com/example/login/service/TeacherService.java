package com.example.login.service;

import com.example.login.entities.Teacher;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

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
    String queryTeacher (String id);

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
    JSONObject power (String teacherId , String roomId);

    /**
     * 查询所有负责人
     * @return
     */
    JSONObject findTeacher();

    /**
     * 根据用户名密码查询负责人
     * @param userName
     * @param passWord
     * @return
     */
    JSONObject findByUserNameAndPassWord(String userName, String passWord);

    /**
     * 修改密码
     * @param passWordH
     * @param passWordY
     * @param userName
     */
    JSONObject updateTeacher(String passWordH, String passWordY, String userName);
}
