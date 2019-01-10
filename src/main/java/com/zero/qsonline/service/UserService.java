package com.zero.qsonline.service;

import com.zero.qsonline.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


public interface UserService extends IService<User> {

    boolean userNameIsExist(String userName, String userId);

}
