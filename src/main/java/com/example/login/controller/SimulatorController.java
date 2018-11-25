package com.example.login.controller;

import com.example.login.ResponseUtils;
import com.example.login.entities.Computer;
import com.example.login.model.Machine;
import com.example.login.repository.ComputerRepository;
import com.example.login.service.ComputerService;
import com.example.login.service.RoomService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.com.BeanClass;

import javax.annotation.Resource;
import java.beans.beancontext.BeanContext;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/simulator")
public class SimulatorController {

    @Resource
    private RoomService roomService;
    @Resource
    private ComputerService computerService;
    @Resource
    private ComputerRepository computerRepository;

    /**
     * 进入模拟器首页
     * @return
     */
    @RequestMapping(value="/index")
    public String index(){
        return "simulatorIndex";
    }

    /**
     * 模拟计算机页面
     * @return
     */
    @RequestMapping(value="/toNewComputer")
    public String toNewComputer(Model model){

        String strRoom = roomService.queryRoom();
        JSONObject json = JSONObject.fromObject(strRoom);
        String state = json.getString("state");
        if(state.equals("0")){
           JSONArray strroomList = (JSONArray)json.get("data");
           model.addAttribute("strroomList",strroomList);
           System.out.println(strroomList);
        }

        return "newcomputer";
    }


    /**
     * 模拟计算机
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/newComputer")
    public Object newComputer(String roomId,Model model){
        if(StringUtils.isEmpty(roomId)){
            return ResponseUtils.fail(1,"缺少必要参数");
        }
        String res = computerService.newlyBuild(roomId);
        JSONObject json = JSONObject.fromObject(res);
        String state = json.getString("state");
        if(state.equals("0")){
            String msg = json.getString("msg");
            return ResponseUtils.ok(msg,"");
        }else{
            return ResponseUtils.fail(1,"创建失败");
        }

    }

    /**
     * 模拟场景
     * @return
     */
    @RequestMapping(value="/ground")
    public String ground(Model model){
        String res = roomService.queryRoom();
        JSONObject json = JSONObject.fromObject(res);
        String state = json.getString("state");
        if(state.equals("0")){
            JSONArray roomList = json.getJSONArray("data");
            model.addAttribute("roomList",roomList);
            return "ground";
        }else{
            model.addAttribute("roomList",null);
            return "ground";
        }

    }


    /**
     * 查看教室内计算机
     * @return
     */
    @RequestMapping(value="/computerByRoomId")
    public String computerByRoomId(String id,Model model){
        String res = computerService.queryComputerByRoomId(id);
        JSONObject json = JSONObject.fromObject(res);
        String state = json.getString("state");
        if(state.equals("0")){
            JSONArray computerList = json.getJSONArray("data");
            model.addAttribute("computerList",computerList);
            return "room";
        }else{
            model.addAttribute("computerList",null);
            return "room";
        }

    }


    /**
     * 开/关机
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/switchs")
    public Object switchs(String computerId,Model model){
        if(StringUtils.isEmpty(computerId)){
            return ResponseUtils.fail(1,"缺少必要参数");
        }
        String res = computerService.getComputerById(computerId);
        JSONObject json = JSONObject.fromObject(res);
        String state = json.getString("state");
        if(state.equals("0")){
            JSONObject computerJson = json.getJSONObject("data");
            Computer computer = (Computer)JSONObject.toBean(computerJson,Computer.class);
            if("0".equals(computer.getUseState())){
                Machine machine = new Machine();
                machine.setId(computerId);
                machine.setState("0");
                machine.setUser("0");
                try {
                    return JSONObject.fromObject(computerService.powerOff(machine));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return ResponseUtils.fail();
                }
            }else{
                Machine machine = new Machine();
                machine.setId(computerId);
                machine.setState("1");
                machine.setUser("0");
                try {
                    return JSONObject.fromObject(computerService.powerOff(machine));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return ResponseUtils.fail();
                }
            }

        }else{
            return ResponseUtils.fail(1,"没有这台计算机");
        }

    }


}
