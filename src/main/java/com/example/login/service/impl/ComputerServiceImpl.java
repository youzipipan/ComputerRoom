package com.example.login.service.impl;

import com.example.login.entities.Computer;
import com.example.login.entities.Warn;
import com.example.login.model.ComputerOverview;
import com.example.login.model.Machine;
import com.example.login.repository.ComputerRepository;
import com.example.login.repository.WarnRepository;
import com.example.login.service.ComputerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
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
    @Transactional
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
        jsonObject.put("state", "0");
        jsonObject.put("msg", "查询成功");
        jsonObject.put("data", computerOverview);
        return jsonObject.toString();
    }

    /**
     * 新建模拟计算机
     *
     * @param roomId
     * @return
     */
    @Transactional
    @Override
    public String newlyBuild(String roomId) {

        Computer computer = new Computer();
        int temperature = (int) (30 * Math.random() + 60);
        int cpu = (int) (40 * Math.random() + 60);
        String computerId = getCard();
        Computer computer1 = computerRepository.findByComputerId(computerId);
        if (computer1 != null) {
            return newlyBuild(roomId);
        } else {
            computer.setComputerId(computerId);
            computer.setCpu(String.valueOf(cpu));
            computer.setTemperature(String.valueOf(temperature));
            computer.setRoomId(roomId);
            computer.setId(UUID.randomUUID().toString());
            computerRepository.save(computer);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state", "0");
            jsonObject.put("msg", "新建成功");
            jsonObject.put("computerId", computerId);
            return jsonObject.toString();
        }
    }

    /**
     * 生成八位随机数
     *
     * @return
     */
    public static String getCard() {
        Random rand = new Random();
        String cardNnumer = "";
        for (int a = 0; a < 8; a++) {
            cardNnumer += rand.nextInt(10);
        }
        return cardNnumer;
    }

    /**
     * 根据教室id查询全部计算机
     *
     * @param roomId
     * @return
     */
    @Transactional
    @Override
    public String queryComputerByRoomId(String roomId) {

        List<Computer> computers = computerRepository.findByRoomId(roomId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "查询成功");
        jsonObject.put("data", computers);
        return jsonObject.toString();
    }

    /**
     * 开机/关机
     *
     * @param machine
     * @return
     */
    @Transactional
    @Override
    public String powerOff(Machine machine) throws ParseException {

        if (machine.getUser() != null && "1".equals(machine.getUser())) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if ("0".equals(machine.getState())) {
                computerRepository.update0(machine.getId());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "0");
                jsonObject.put("msg", "开机成功");
                return jsonObject.toString();
            } else if ("1".equals(machine.getState())) {
                String date = df.format(new Date());
                computerRepository.update1(machine.getId(), date);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "0");
                jsonObject.put("msg", "关机成功");
                return jsonObject.toString();
            } else if ("2".equals(machine.getState())) {
                computerRepository.update2();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "0");
                jsonObject.put("msg", "一键开机成功");
                return jsonObject.toString();
            } else if ("3".equals(machine.getState())) {
                String date = df.format(new Date());
                computerRepository.upfate3(date);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "0");
                jsonObject.put("msg", "一键关机机成功");
                return jsonObject.toString();
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "1");
                jsonObject.put("msg", "非正常操作");
                return jsonObject.toString();
            }
        } else {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date begin = df.parse("08:00");
            Date end = df.parse("18:00");
            Date now = df.parse(df.format(new Date()));
            if (now.after(begin) && now.before(end)) {
                if ("0".equals(machine.getState())) {
                    computerRepository.update0(machine.getId());
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "0");
                    jsonObject.put("msg", "开机成功");
                    return jsonObject.toString();
                } else if ("1".equals(machine.getState())) {
                    SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = dfs.format(new Date());
                    computerRepository.update1(machine.getId(), date);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "0");
                    jsonObject.put("msg", "关机成功");
                    return jsonObject.toString();
                } else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "1");
                    jsonObject.put("msg", "非正常操作");
                    return jsonObject.toString();
                }
            } else {
                Warn warn = new Warn();
                warn.setId(UUID.randomUUID().toString());
                warn.setComputerId(machine.getId());
                warn.setDoState("2");
                SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dfs.format(new Date());
                warn.setCreateTime(date);
                Computer computer = computerRepository.findByComputerId(machine.getId());
                String warnMsg = computer.getRoomId() + machine.getId() + "号计算机在非使用时间使用";
                warn.setWarnMsg(warnMsg);
                warnRepository.save(warn);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "2");
                jsonObject.put("msg", "非使用时间使用");
                return jsonObject.toString();
            }
        }
    }
}
