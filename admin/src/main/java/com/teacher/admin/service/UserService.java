package com.teacher.admin.service;

import com.teacher.admin.entity.User;

import java.util.List;

public interface UserService {

    List<User> getList(User user);

    String login(String username, String password);
}
