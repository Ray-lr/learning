package com.teacher.admin.controller;

import com.teacher.admin.entity.User;
import com.teacher.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *@author : Ray
 *@date :  2021/1/23 22:15
 *description: user controller
 ***/
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getList(@RequestParam(required = false) User user) {
        if (user == null) {
            user = new User();
        }
        List<User> result = userService.getList(user);
        return ResponseEntity.ok(result);
    }
}
