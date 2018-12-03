package com.example.login.service;

import com.example.login.model.Machine;
import net.sf.json.JSONObject;

import java.text.ParseException;

public interface ComputerService {

    /**
     * 计算机总览
     * @return
     */
    String overview();

    /**
     * 新建模拟计算机
     */
    String newlyBuild(String roomId);

    /**
     * 根据教室id查询全部计算机
     */
    String queryComputerByRoomId(String roomId);

    /**
     * 开机/关机
     * @param machine
     * @return
     */
    String powerOff(Machine machine) throws ParseException;

    /**
     * 显示全部信息
     * @return
     */
    String showAll();

    /**
     * 强制下机/锁机
     * @param id
     * @return
     */
    String lock(String id);

    /**
     * 解锁
     * @param id
     * @return
     */
    String unlock(String id,String userName,String passWord,String user);

    /**
     * 根据Id查找计算机
     * @param id
     * @return
     */
    public String getComputerById(String id);

    void editComputerToRoom(String comId, String roomId);

    String showByTeacher(String teacherId);
}
