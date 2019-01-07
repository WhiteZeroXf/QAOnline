package com.zero.qsonline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zero.qsonline.service.DeptService;
import com.zero.qsonline.entity.Dept;

import com.zero.qsonline.base.BaseController;

@RestController
@RequestMapping("/api/v1/dept")
public class DeptController extends BaseController<Dept> {

    private final Logger logger = LoggerFactory.getLogger(DeptController.class);

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @Override
    protected IService service() {
        return this.deptService;
    }


}

