package com.example.login.service.impl;

import com.example.login.entities.*;
import com.example.login.model.ComputerInformation;
import com.example.login.model.ComputerOverview;
import com.example.login.model.Machine;
import com.example.login.repository.*;
import com.example.login.service.ComputerService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class ComputerServiceImpl implements ComputerService {

    @Resource
    private ComputerRepository computerRepository;

    @Resource
    private WarnRepository warnRepository;

    @Resource
    private TeacherRepository teacherRepository;

    @Resource
    private RoomRepository roomRepository;

    @Resource
    private TeacherRoomRepository teacherRoomRepository;

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
            computer.setWrongTime("0");
            computer.setUseState("0");
            computer.setLockState("0");
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
                List<Computer> computerList = computerRepository.findAll();
                computerList.forEach(e -> {
                    if (e.getUseState() != null && "1".equals(e.getUseState())) {
                        String date = df.format(new Date());
                        computerRepository.upfate3(date, e.getId());
                    }
                });
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "0");
                jsonObject.put("msg", "一键关机成功");
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
            Date end = df.parse("16:59");
            Date now = df.parse(df.format(new Date()));
            if (now.after(begin) && now.before(end)) {
                if ("0".equals(machine.getState())) {
                    computerRepository.update0(machine.getId());
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "0");
                    jsonObject.put("msg", "开机成功");
                    return jsonObject.toString();
                }  else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "1");
                    jsonObject.put("msg", "非正常操作");
                    return jsonObject.toString();
                }
            } else {
                if ("1".equals(machine.getState())) {
                    SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = dfs.format(new Date());
                    computerRepository.update1(machine.getId(), date);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("state", "0");
                    jsonObject.put("msg", "关机成功");
                    return jsonObject.toString();
                }
                Warn warn = new Warn();
                warn.setId(UUID.randomUUID().toString());
                warn.setComputerId(machine.getId());
                warn.setDoState("2");
                SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dfs.format(new Date());
                warn.setCreateTime(date);
                Computer computer = computerRepository.findComputerById(machine.getId());
                Room room = roomRepository.findRoomById(computer.getRoomId());
                String warnMsg = room.getName() + "的" + computer.getComputerId() + "号计算机在非使用时间使用";
                warn.setWarnMsg(warnMsg);
                warnRepository.save(warn);
                computerRepository.updates(machine.getId());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "2");
                jsonObject.put("msg", "非使用时间使用");
                return jsonObject.toString();
            }
        }
    }

    /**
     * 显示全部信息
     *
     * @return
     */
    @Transactional
    @Override
    public String showAll() {

        List<Computer> computerList = computerRepository.findAll();
        List<ComputerInformation> computers = new ArrayList<>();

        computerList.forEach(computer -> {
            ComputerInformation computerInformation = new ComputerInformation();
            computerInformation.setId(computer.getId());
            computerInformation.setComputerId(computer.getComputerId());
            Room room = roomRepository.findRoomById(computer.getRoomId());
            computerInformation.setRoom(room.getName());
            computerInformation.setUseState(computer.getUseState());
            computerInformation.setLockState(computer.getLockState());
            computerInformation.setLastUseState(computer.getLastUseState());
            computerInformation.setTemperature(computer.getTemperature());
            computerInformation.setCpu(computer.getCpu());
            computers.add(computerInformation);
        });
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", "0");
        jsonObject.put("msg", "开机成功");
        jsonObject.put("data", computers);
        return jsonObject.toString();
    }

    /**
     * 强制下机/锁机
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String lock(String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            computerRepository.updateLock(id);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("state", "1");
            jsonObject.put("msg", "锁机失败");
            return jsonObject.toString();
        }

        jsonObject.put("state", "0");
        jsonObject.put("msg", "锁机成功");
        return jsonObject.toString();
    }

    /**
     * 解锁
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String unlock(String id, String userName, String passWord, String user) {

        Teacher teacher = teacherRepository.findTeacher(userName, passWord);
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(user)) {
            computerRepository.updateUnlock(id);
            jsonObject.put("state", "0");
            jsonObject.put("msg", "解锁成功");
            return jsonObject.toString();
        }
        if (teacher != null) {
            computerRepository.updateUnlock(id);
            jsonObject.put("state", "0");
            jsonObject.put("msg", "解锁成功");
        } else {
//            Warn warn = warnRepository.findWarnById(id);
            Computer computer = computerRepository.findComputerById(id);
            String wrong = "";
            if ("0".equals(computer.getWrongTime())) {
                wrong = "1";
                computerRepository.updateWrong(wrong, computer.getId());
            } else if ("2".equals(computer.getWrongTime())) {
                Warn warn1 = new Warn();
                warn1.setId(UUID.randomUUID().toString().replace("-",""));
                warn1.setComputerId(computer.getId());
                SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dfs.format(new Date());
                warn1.setCreateTime(date);
                warn1.setDoState("0");
                Room room = roomRepository.findRoomById(computer.getRoomId());
                warn1.setWarnMsg(room.getName()+"的"+computer.getComputerId()+"号计算机遭到入侵，锁定状态连续输错三次");
                warnRepository.save(warn1);
            } else {
                int i = Integer.valueOf(computer.getWrongTime());
                i = i + 1;
                wrong = (String.valueOf(i));
                computerRepository.updateWrong(wrong, computer.getId());
            }
            jsonObject.put("state", "9");
            jsonObject.put("msg", "负责人信息错误，解锁失败");
        }
        return jsonObject.toString();
    }

    /**
     * 根据id查找计算机
     * @param id
     * @return
     */
    @Transactional
    @Override
    public String getComputerById(String id) {

        Computer computer = computerRepository.findComputerById(id);
        JSONObject jsonObject = new JSONObject();
        if (computer != null) {
            jsonObject.put("state", "0");
            jsonObject.put("msg", "查询成功");
            jsonObject.put("data", computer);
        } else {
            jsonObject.put("state", "1");
            jsonObject.put("msg", "未查询到计算机");
        }
        return jsonObject.toString();
    }

    /**
     * com更换教室
     *
     * @param comId
     * @param roomId
     */
    @Override
    public void editComputerToRoom(String comId, String roomId) {
        computerRepository.updateComputerToRoom(comId, roomId);
    }

    @Override
    public JSONObject showByTeacher(String teacherId) {

        TeacherRoom teacherRoom = teacherRoomRepository.findByTeacherId(teacherId);
        if(teacherRoom!=null){
            List<Computer> computerlist = computerRepository.findByRoomId(teacherRoom.getRoomId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state", "0");
            jsonObject.put("msg", "查询成功");
            jsonObject.put("data", computerlist);
            return jsonObject;
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state", "1");
            jsonObject.put("msg", "信息错误！");
            return jsonObject;
        }
    }
}
