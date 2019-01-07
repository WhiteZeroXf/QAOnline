package com.zero.qsonline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zero.qsonline.service.UserService;
import com.zero.qsonline.entity.User;

import com.zero.qsonline.base.BaseController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController<User> {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected IService service() {
        return this.userService;
    }


}

