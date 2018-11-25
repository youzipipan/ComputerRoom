package com.example.login.controller;

import com.example.login.ResponseUtils;
import com.example.login.entities.Computer;
import com.example.login.model.ComputerOverview;
import com.example.login.model.Machine;
import com.example.login.service.ComputerService;
import com.example.login.service.RoomService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;

@Controller
@RequestMapping(value="admin")
public class RoomControler {

    @Resource
    private RoomService roomService;
    @Resource
    private ComputerService computerService;

    @RequestMapping(value="/index")
    public String index(Model model){

        String res = computerService.overview();

        JSONObject jsonss = JSONObject.fromObject(res);
        if("0".equals(jsonss.getString("state"))){
            JSONObject json = jsonss.getJSONObject("data");
            model.addAttribute("json",json);
        }else{
            ComputerOverview computerOverview = new ComputerOverview();
            computerOverview.setComputerCount("0");
            computerOverview.setUseCount("0");
            computerOverview.setBadCount(String.valueOf(0));
            computerOverview.setWarnCount(String.valueOf(0));
        }

        return "index";
    }


    @RequestMapping(value="/computerManerger")
    public String computerManerger(Model model){

        String res = computerService.showAll();

        JSONObject jsonss = JSONObject.fromObject(res);
        if("0".equals(jsonss.getString("state"))){
            JSONArray json = jsonss.getJSONArray("data");
            model.addAttribute("json",json);
        }else{
            model.addAttribute("json",null);
        }

        return "computerManerger";
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
                machine.setUser("1");
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
                machine.setUser("1");
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


    /**
     * 一键开机
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/allswitchs")
    public Object allswitchs(Model model){

        Machine machine = new Machine();
        machine.setState("2");
        machine.setUser("1");
        try {
            return JSONObject.fromObject(computerService.powerOff(machine));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseUtils.fail();
        }

    }

    /**
     * 一键关机
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/allguanji")
    public Object allguanji(Model model){

        Machine machine = new Machine();
        machine.setState("3");
        machine.setUser("1");
        try {
            return JSONObject.fromObject(computerService.powerOff(machine));
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseUtils.fail();
        }

    }

    /**
     * 锁机
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/lock")
    public Object lock(String id,Model model){

        return JSONObject.fromObject(computerService.lock(id));
    }

}
