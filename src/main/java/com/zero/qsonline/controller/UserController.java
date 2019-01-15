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
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 用户管理页
     */
    @GetMapping("delete")
    public String delete(@RequestParam String id) {
        userService.removeById(id);
        return "redirect:/api/v1/user/um";
    }

    /**
     * 更新用户
     *
     * @param update  更新用户实体
     * @param user    session中存在的用户
     * @param request 用户请求
     * @param map     返回封装
     * @return 用户信息页
     */
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
        // 更新session中的用户实体
        request.getSession().setAttribute("user", user);
        // 更新用户
        userService.updateById(user);
        return "userInfo";
    }

    /**
     * 退出登录
     *
     * @param request 用户请求
     * @return 首页
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        // 清空session
        request.getSession().invalidate();
        return "redirect:/";
    }

    /**
     * 获取某个用户的信息
     *
     * @param id  用户id
     * @param map 返回集合
     * @return 用户详情页
     */
    @GetMapping("change")
    public String add(@RequestParam String id, ModelMap map) {
        map.put("user", userService.getById(id));
        return "changeU";
    }

    /**
     * 新增用户
     *
     * @param map  返回集合
     * @param user 新增的用户
     * @return 用户管理/新增用户页
     */
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
        // 向数据库中插入用户
        userService.save(user);
        return "redirect:/api/v1/user/um";
    }

    /**
     * 管理员更新用户
     *
     * @param map  返回集合
     * @param user 要更新的用户
     * @return 用户管理页/用户信息页
     */
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

        // 校验登录名是否存在
        if (userService.userNameIsExist(user.getUserName(), user.getUserId())) {
            map.put("user", user);
            map.put("errName", "登录名已存在");
            return "changeU";
        }
        // 更新用户
        userService.updateById(user);
        return "redirect:/api/v1/user/um";
    }

    /**
     * 用户管理
     *
     * @param map  返回集合
     * @param user 登录管理员
     * @return 用户管理页面
     */
    @GetMapping("um")
    public String listAll(ModelMap map, @SessionAttribute(required = false) User user) {
        List<User> list = userService.list();
        if (user != null) {
            // 将当前登录管理员排除
            for (User user1 : list) {
                if (user1.getUserId().equals(user.getUserId())) {
                    list.remove(user1);
                    break;
                }
            }
        }
        map.put("users", list);
        return "um";
    }

    /**
     * 用户登录
     * @param session session
     * @param login 用户实体
     * @param map 返回集合
     * @return 首页/登录页
     */
    @PostMapping("login")
    public String login(HttpSession session, User login, ModelMap map) {
        map.put("userName", login.getUserName());
        map.put("password", login.getPassword());
        if (login.getUserName() == null || "".equals(login.getUserName())) {
            map.put("err", "用户名为空");
            return "login";
        }
        // 通过用户名和密码获取用户
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(User.USER_NAME, login.getUserName())
                .eq(User.PASSWORD, login.getPassword()));
        if (user == null) {
            map.put("err", "用户名或密码错误");
            return "login";
        }
        // 将登录用户添加到session中
        session.setAttribute("user", user);
        return "redirect:/api/v1/question/all";
    }
}

