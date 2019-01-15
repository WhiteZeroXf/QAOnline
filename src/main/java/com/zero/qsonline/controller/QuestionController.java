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
public class QuestionController {

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

    /**
     * 获取所有问题
     * @param map 返回集合
     * @return 所有问题页
     */
    @GetMapping("all")
    public String index(ModelMap map) {
        map.put("questions", questionService.listAll());
        return "questions";
    }

    /**
     * 问题管理
     * @param map 返回集合
     * @return 问题管理页
     */
    @GetMapping("qm")
    public String questionManage(ModelMap map) {
        map.put("questions", questionService.listAll());
        return "qm";
    }

    /**
     * 获取热点问题
     * @param map 返回集合
     * @return 热点问题页
     */
    @GetMapping("hot")
    public String hot(ModelMap map) {
        map.put("questions", questionService.listHot());
        return "questions";
    }

    /**
     * 新增问题
     * @param question 问题
     * @param user 用户
     * @return 问题详情页
     */
    @PostMapping("add")
    public String add(Question question, @SessionAttribute User user) {
        question.setUserId(user.getUserId());
        // 向数据库插入数据
        questionService.save(question);
        return "redirect:/api/v1/question/one?id=" + question.getQuestionId();
    }

    /**
     * 获取精品问题
     * @param map 返回集合
     * @return 精品问题页
     */
    @GetMapping("quality")
    public String quality(ModelMap map) {
        map.put("questions", questionService.listQuality());
        return "questions";
    }

    /**
     * 更新问题
     * @param id 问题id
     * @param type 问题类型
     * @return 问题管理页
     */
    @GetMapping("update")
    public String update(@RequestParam String id, @RequestParam int type) {
        // 新增用户实体
        Question question = new Question();
        question.setQuestionId(id);
        question.setQuestionType(type);
        // 向数据库插入数据
        questionService.updateById(question);
        return "redirect:/api/v1/question/qm";
    }

    /**
     * 删除问题
     * @param id 问题id
     * @return 问题管理页
     */
    @GetMapping("delete")
    public String deleteById(@RequestParam String id) {
        // 从数据库删除数据
        questionService.removeById(id);
        return "redirect:/api/v1/question/qm";
    }

    /**
     * 获取一个问题
     * @param map 返回集合
     * @param id 问题id
     * @return 问题详情页
     */
    @GetMapping("one")
    public String one(ModelMap map, @RequestParam String id) {
        // 获取问题
        Question question = questionService.getOne(new QueryWrapper<Question>().eq(Question.QUESTION_ID, id));
        if (question == null) {
            return "redirect:/api/v1/question/all";
        }
        // 获取问题所属用户
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(User.USER_ID, question.getUserId()));
        // 获取问题所有的回复
        List<Answer> answers = answerService.list(new QueryWrapper<Answer>()
                .eq(Answer.QUESTION_ID, question.getQuestionId())
                .orderByDesc(Answer.CREATE_TIME));
        map.put("question", question);
        map.put("author", user);
        map.put("answers", answers);
        return "question";
    }

}

