package com.zero.qsonline.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("all")
    public String index(ModelMap map) {
        map.put("questions", questionService.listAll());
        return "questions";
    }

    @GetMapping("qm")
    public String questionManage(ModelMap map) {
        map.put("questions", questionService.listAll());
        return "qm";
    }

    @GetMapping("hot")
    public String hot(ModelMap map) {
        map.put("questions", questionService.listHot());
        return "questions";
    }

    @PostMapping("add")
    public String add(Question question, @SessionAttribute User user) {
        question.setUserId(user.getUserId());
        question.insert();
        return "redirect:/api/v1/question/one?id=" + question.getQuestionId();
    }

    @GetMapping("quality")
    public String quality(ModelMap map) {
        map.put("questions", questionService.listQuality());
        return "questions";
    }

    @GetMapping("update")
    public String update(@RequestParam String id, @RequestParam int type) {
        Question question = new Question();
        question.setQuestionId(id);
        question.setQuestionType(type);
        questionService.updateById(question);
        return "redirect:/api/v1/question/qm";
    }

    @GetMapping("delete")
    public String deleteById(@RequestParam String id) {
        questionService.removeById(id);
        return "redirect:/api/v1/question/qm";
    }

    @GetMapping("one")
    public String one(ModelMap map, @RequestParam String id) {
        Question question = questionService.getOne(new QueryWrapper<Question>().eq(Question.QUESTION_ID, id));
        if (question == null) {
            return "redirect:/api/v1/question/all";
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

