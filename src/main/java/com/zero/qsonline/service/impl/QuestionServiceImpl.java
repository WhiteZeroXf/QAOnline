package com.zero.qsonline.service.impl;

import com.zero.qsonline.entity.Question;
import com.zero.qsonline.dao.QuestionMapper;
import com.zero.qsonline.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
