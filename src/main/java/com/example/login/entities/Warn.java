package com.example.login.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="t_warn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warn {

    @Id
    private String id;
    @Column
    private String computerId;	//计算机唯一标识
    @Column
    private String warnMsg;		//警报信息（301室X号计算机非法使用：非授课时间段进行操作）或（301室X号计算机遭到入侵：锁定状态连续输错三次）
    @Column
    private String doState;		//处理状态（0未处理 1已处理 2自动处理）
    @Column
    private String createTime;	//发生警报时间（YYYY-mm-dd hh：mm：ss）

}
