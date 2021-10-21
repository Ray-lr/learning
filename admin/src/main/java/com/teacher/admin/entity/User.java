package com.teacher.admin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/***
 *@author : Ray
 *@date :  2021/1/23 21:35
 *description: t_user
 ***/
@Data
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty("id")
    private Long id;
    @ExcelProperty("用户名")
    private String username;
    @ExcelProperty("密码")
    private String password;
    @ExcelProperty("别称")
    private String displayName;
    @ExcelProperty("手机号")
    private String phoneNumber;
    private String address;
    private String avatar;
    private String description;
    private boolean sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastLoginTime;
    private boolean isDeleted;

    public User(
            Long userId, String username, String password,
            String displayName, String phoneNumber) {
        this.id = userId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
    }

}
