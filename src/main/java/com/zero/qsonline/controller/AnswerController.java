package com.zero.qsonline.controller;

import com.zero.qsonline.entity.Answer;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

// spring注解，标识这个类为controller
@Controller
// spring注解，标识这个类要处理的请求uri
@RequestMapping("/api/v1/answer")
public class AnswerController {

    private final AnswerService answerService;

    // spring注解，自动注入
    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     * 新增回复
     * @param user 用户
     * @param answer 回复
     * @return 问题详情页
     */
    // spring注解，标识这个方法要处理的POST请求的uri
    @PostMapping("add")
    public String addAnswer(@SessionAttribute User user,// spring注解，标识这个实体来自session
                            Answer answer) {
        System.out.println(answer.getContent());
        answer.setUserId(user.getUserId());
        answerService.save(answer);
        return "redirect:/api/v1/question/one?id=" + answer.getQuestionId();
    }

}

