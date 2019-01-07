package com.zero.qsonline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.extension.service.IService;

import com.zero.qsonline.service.QuestionService;
import com.zero.qsonline.entity.Question;

import com.zero.qsonline.base.BaseController;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController extends BaseController<Question> {

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    protected IService service() {
        return this.questionService;
    }


}

