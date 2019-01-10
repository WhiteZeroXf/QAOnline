package com.zero.qsonline.controller;


import com.zero.qsonline.entity.Class;
import com.zero.qsonline.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController extends BaseController<Class> {

    private final Logger logger = LoggerFactory.getLogger(ClassController.class);

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }


}

