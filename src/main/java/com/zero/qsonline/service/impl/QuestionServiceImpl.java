package com.zero.qsonline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zero.qsonline.dao.QuestionMapper;
import com.zero.qsonline.entity.Question;
import com.zero.qsonline.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public List<Map<String, Object>> listAll() {
        // 获取全部问题
        return questionMapper.getAll();
    }

    @Override
    public List<Map<String, Object>> listQuality() {
        // 获取热点问题
        return questionMapper.getByType(1);
    }

    @Override
    public List<Map<String, Object>> listHot() {
        // 获取精品问题
        return questionMapper.getByType(2);
    }
}
