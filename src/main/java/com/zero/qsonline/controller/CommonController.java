package com.zero.qsonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/8 15:59
 */
@Controller
public class CommonController {

    @GetMapping("/")
    public String index() {
        return "redirect:/api/v1/question/all";
    }

    @GetMapping("/to/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

}
