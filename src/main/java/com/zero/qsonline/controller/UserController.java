package com.zero.qsonline.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.qsonline.base.BaseController;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
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

    @GetMapping("toLogin")
    public String toLogin(ModelMap map) {
        map.put("login", new User());
        return "login";
    }

    @PostMapping("login")
    public String login(HttpSession session, User login, ModelMap map) {
        map.put("userName", login.getUserName());
        map.put("password", login.getPassword());
        if (login.getUserName() == null || "".equals(login.getUserName())) {
            map.put("err", "用户名为空");
            return "login";
        }
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(User.USER_NAME, login.getUserName())
                .eq(User.PASSWORD, login.getPassword()));
        if (user == null) {
            map.put("err", "用户名或密码错误");
            return "login";
        }
        session.setAttribute("user", user);
        return "redirect:/api/v1/question/all";
    }
}

