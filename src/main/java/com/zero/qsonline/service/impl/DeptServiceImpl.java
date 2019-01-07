package com.zero.qsonline.service.impl;

import com.zero.qsonline.entity.Dept;
import com.zero.qsonline.dao.DeptMapper;
import com.zero.qsonline.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
