package com.zero.qsonline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zero.qsonline.dao.UserMapper;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean userNameIsExist(String userName, String userId) {
        return this.getOne(new QueryWrapper<User>()
                .eq(User.USER_NAME, userName)
                .ne(User.USER_ID, userId)) != null;
    }
}
