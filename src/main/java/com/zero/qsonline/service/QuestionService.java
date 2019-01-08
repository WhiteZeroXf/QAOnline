package com.zero.qsonline.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.qsonline.entity.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService extends IService<Question> {

    List<Map<String, Object>> listAll();

    List<Map<String, Object>> listQuality();

    List<Map<String, Object>> listHot();
}
