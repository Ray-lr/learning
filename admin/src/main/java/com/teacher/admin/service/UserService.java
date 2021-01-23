package com.teacher.admin.service;

import com.teacher.admin.entity.User;
import com.teacher.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserService {

    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     *@author : Ray
     *@date : 2021/1/23 22:13
     *@param user: condition
     *@return : result list
     * description: get user list by given condition
     **/
    public List<User> getList(User user) {
        List<User> list = userMapper.select(user);
        if (CollectionUtils.isEmpty(list)) {
            log.error("can't find user by condition of user {}",user.toString());
        }
        return list;
    }
}
