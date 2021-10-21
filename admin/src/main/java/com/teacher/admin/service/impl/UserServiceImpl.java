package com.teacher.admin.service.impl;

import com.teacher.admin.entity.User;
import com.teacher.admin.mapper.UserMapper;
import com.teacher.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

/***
 *@author : Ray
 *@date :  2021/1/23 22:08
 *description: user service
 ***/
@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     *@author : Ray
     *@date : 2021/1/23 22:13
     *@param user: condition
     *@return : result list
     * description: get user list by given condition
     **/
    @Override
    public List<User> getList(User user) {
        List<User> list = userMapper.select(user);
        if (CollectionUtils.isEmpty(list)) {
            log.error("can't find user by condition of user {}",user.toString());
        }
        return list;
    }

    /**
     * @param username:
     * @param password:
     * @return : login success or failed
     * @author : lirui
     * @date :  2021/5/11
     * @description : login
     **/
    @Override
    public String login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userMapper.selectOne(user);
        if (user!=null && user.getId()!=null) {
            return "success";
        } else {
            return "failed";
        }
    }
}
