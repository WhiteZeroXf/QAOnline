package com.zero.qsonline.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zero.qsonline.entity.User;
import com.zero.qsonline.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
public class UserController extends BaseController<User> {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("toLogin")
    public String toLogin(ModelMap map) {
        map.put("login", new User());
        return "login";
    }

    @GetMapping("delete")
    public String delete(@RequestParam String id) {
        userService.removeById(id);
        return "redirect:/api/v1/user/um";
    }

    @PostMapping("update")
    public String update(User update, @SessionAttribute User user, HttpServletRequest request, ModelMap map) {
        if (update.getPassword() == null || "".equals(update.getPassword())) {
            map.put("errPwd", "密码为空");
            map.put("user", user);
            return "userInfo";
        }
        if (update.getUserNickName() == null || "".equals(update.getUserNickName())) {
            map.put("errNick", "昵称为空");
            map.put("user", user);
            return "userInfo";
        }

        user.setPassword(update.getPassword());
        user.setUserNickName(update.getUserNickName());
        request.getSession().setAttribute("user", user);
        userService.saveOrUpdate(user);
        return "userInfo";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @GetMapping("change")
    public String add(@RequestParam String id, ModelMap map) {
        map.put("user", userService.getById(id));
        return "changeU";
    }

    @PostMapping("add")
    public String add(ModelMap map, User user) {
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            map.put("errName", "用户名为空");
            map.put("user", user);
            return "addU";
        }
        if (user.getUserGender() == null || "".equals(user.getUserGender())) {
            map.put("errSex", "请选择性别");
            map.put("user", user);
            return "addU";
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            map.put("errPwd", "密码为空");
            map.put("user", user);
            return "addU";
        }
        if (user.getUserNickName() == null || "".equals(user.getUserNickName())) {
            map.put("errNick", "昵称为空");
            map.put("user", user);
            return "addU";
        }
        if (userService.userNameIsExist(user.getUserName(), user.getUserId())) {
            map.put("errName", "登录名已存在");
            map.put("user", user);
            return "addU";
        }
        user.insert();
        return "redirect:/api/v1/user/um";
    }

    @PostMapping("update/admin")
    public String updateAdmin(ModelMap map, User user) {
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            map.put("errName", "用户名为空");
            map.put("user", user);
            return "addU";
        }
        if (user.getUserGender() == null || "".equals(user.getUserGender())) {
            map.put("errSex", "请选择性别");
            map.put("user", user);
            return "addU";
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            map.put("errPwd", "密码为空");
            map.put("user", user);
            return "addU";
        }
        if (user.getUserNickName() == null || "".equals(user.getUserNickName())) {
            map.put("errNick", "昵称为空");
            map.put("user", user);
            return "addU";
        }

        if (userService.userNameIsExist(user.getUserName(), user.getUserId())) {
            map.put("user", user);
            map.put("errName", "登录名已存在");
            return "changeU";
        }
        userService.updateById(user);
        return "redirect:/api/v1/user/um";
    }

    @GetMapping("um")
    public String listAll(ModelMap map, @SessionAttribute(required = false) User user) {
        List<User> list = userService.list();
        if (user != null) {
            list.removeIf(u -> u.getUserId().equals(user.getUserId()));
        }
        map.put("users", list);
        return "um";
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

