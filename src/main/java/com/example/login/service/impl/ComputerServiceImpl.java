package com.example.login.service.impl;

import com.example.login.entities.Computer;
import com.example.login.entities.Warn;
import com.example.login.model.ComputerOverview;
import com.example.login.repository.ComputerRepository;
import com.example.login.repository.WarnRepository;
import com.example.login.service.ComputerService;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class ComputerServiceImpl implements ComputerService {

    @Resource
    private ComputerRepository computerRepository;

    @Resource
    private WarnRepository warnRepository;

    /**
     * 计算机总览
     *
     * @return
     */
    @Override
    public String overview() {

        ComputerOverview computerOverview = new ComputerOverview();
        List<Computer> computerList = computerRepository.findAll();
        int useCount = 0;
        int badCount = 0;
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getUseState() != null && "1".equals(computerList.get(i).getUseState())) {
                useCount++;
            }
            if (Integer.valueOf(computerList.get(i).getTemperature()) > 80 || Integer.valueOf(computerList.get(i).getCpu()) > 90) {
                badCount++;
            }
        }
        Date date = new Date();
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = sdf2.format(date);
        List<Warn> warnList = warnRepository.findAll(formatDate);
        computerOverview.setComputerCount(String.valueOf(computerList.size()));
        computerOverview.setUseCount(String.valueOf(useCount));
        computerOverview.setBadCount(String.valueOf(badCount));
        computerOverview.setWarnCount(String.valueOf(warnList.size()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","查询成功");
        jsonObject.put("data",computerOverview);
        return jsonObject.toString();
    }

    /**
     *新建模拟计算机
     * @param roomId
     * @return
     */
    @Override
    public String newlyBuild(String roomId) {

        Computer computer = new Computer();
        int temperature = (int) ( 30 * Math.random() + 60);
        int cpu = (int) ( 40 * Math.random() + 60);

        Random rand=new Random();
        String computerId="";
        for(int a=0;a<8;a++){
            computerId+=rand.nextInt(10);
        }
        computer.setComputerId(computerId);
        computer.setCpu(String.valueOf(cpu));
        computer.setTemperature(String.valueOf(temperature));
        computer.setRoomId(roomId);
        computer.setId(UUID.randomUUID().toString());
        computerRepository.save(computer);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","新建成功");
        jsonObject.put("computerId",computerId);
        return jsonObject.toString();
    }

    /**
     * 根据教室id查询全部计算机
     * @param roomId
     * @return
     */
    @Override
    public String queryComputerByRoomId(String roomId) {

        List<Computer> computers = computerRepository.findByRoomId(roomId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","0");
        jsonObject.put("msg","查询成功");
        jsonObject.put("data",computers);
        return jsonObject.toString();
    }
}
