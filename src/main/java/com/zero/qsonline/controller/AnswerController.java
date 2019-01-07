package com.zero.qsonline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zero.qsonline.service.AnswerService;
import com.zero.qsonline.entity.Answer;

import com.zero.qsonline.base.BaseController;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController extends BaseController<Answer> {

    private final Logger logger = LoggerFactory.getLogger(AnswerController.class);

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Override
    protected IService service() {
        return this.answerService;
    }


}

