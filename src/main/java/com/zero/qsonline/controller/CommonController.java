package com.zero.qsonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommonController {

    /**
     * 登录跳转
     * @return 登录页
     */
    // spring注解，标识这个方法要处理的Get请求的uri
    @GetMapping("/")
    public String index() {
        return "redirect:/to/login";
    }

    /**
     * 页面跳转，去某个页面
     * @param page 要去的页面
     * @return 具体页面
     */
    @GetMapping("/to/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

}
