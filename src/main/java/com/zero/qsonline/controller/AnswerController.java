package com.zero.qsonline.controller;

import com.zero.qsonline.entity.Answer;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/api/v1/answer")
public class AnswerController extends BaseController<Answer> {

    private final Logger logger = LoggerFactory.getLogger(AnswerController.class);

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("add")
    public String addAnswer(@SessionAttribute User user, Answer answer) {
        System.out.println(answer.getContent());
        answer.setUserId(user.getUserId());
        answerService.save(answer);
        return "redirect:/api/v1/question/one?id=" + answer.getQuestionId();
    }

}

