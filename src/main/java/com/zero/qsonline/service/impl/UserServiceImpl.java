package com.zero.qsonline.service.impl;

import com.zero.qsonline.entity.User;
import com.zero.qsonline.dao.UserMapper;
import com.zero.qsonline.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
