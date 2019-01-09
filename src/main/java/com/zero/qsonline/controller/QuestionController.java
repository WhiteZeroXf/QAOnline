package com.zero.qsonline.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.qsonline.base.BaseController;
import com.zero.qsonline.entity.Answer;
import com.zero.qsonline.entity.Question;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.AnswerService;
import com.zero.qsonline.service.QuestionService;
import com.zero.qsonline.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/question")
public class QuestionController extends BaseController<Question> {

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    private final QuestionService questionService;
    private final UserService userService;
    private final AnswerService answerService;

    @Autowired
    public QuestionController(QuestionService questionService, UserService userService, AnswerService answerService) {
        this.questionService = questionService;
        this.userService = userService;
        this.answerService = answerService;
    }

    @Override
    protected IService service() {
        return this.questionService;
    }

    @GetMapping("all")
    public String index(ModelMap map) {
        map.put("questions", questionService.listAll());
        return "questions";
    }

    @GetMapping("hot")
    public String hot(ModelMap map) {
        map.put("questions", questionService.listHot());
        return "questions";
    }

    @GetMapping("quality")
    public String quality(ModelMap map) {
        map.put("questions", questionService.listQuality());
        return "questions";
    }

    @GetMapping("one")
    public String one(ModelMap map, @RequestParam String id) {
        Question question = questionService.getOne(new QueryWrapper<Question>().eq(Question.QUESTION_ID, id));
        if (question == null) {
            return "redirect:/";
        }
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(User.USER_ID, question.getUserId()));
        List<Answer> answers = answerService.list(new QueryWrapper<Answer>()
                .eq(Answer.QUESTION_ID, question.getQuestionId())
                .orderByDesc(Answer.CREATE_TIME));
        map.put("question", question);
        map.put("author", user);
        map.put("answers", answers);
        return "question";
    }

}

