package com.teacher.admin.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.teacher.admin.entity.User;
import com.teacher.admin.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *@author : Ray
 *@date :  2021/1/23 22:15
 *description: user controller
 ***/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/login/test")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String result;
        try {
            result = userServiceImpl.login(username, password);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getList(@RequestParam(required = false) User user) {
        if (user == null) {
            user = new User();
        }
        List<User> result = userServiceImpl.getList(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/download")
    public ResponseEntity<String> getExcel(HttpServletResponse response) throws IOException {
        List<User> list = this.init();
        String templateFileName =
                "D:\\projects\\learning\\admin\\src\\main\\resources\\templates\\test.xlsx";
        response.setHeader("Content-disposition", "attachment;filename=" + "realExcel" + ".xlsx");
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        Map<String,Object> map = new HashMap<>(1);
        map.put("time",System.currentTimeMillis());
        excelWriter.fill(map,writeSheet);
        excelWriter.fill(list,writeSheet);
        excelWriter.finish();
        return ResponseEntity.ok("下载成功！");
    }

    private List<User> init() {
        List<User> list = new ArrayList<>(10);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            list.add(new User((long)i,"username" + i,
                    "password" + i,"昵称" + i,
                    "1"+random.nextLong()));
        }
        return list;
    }
}
