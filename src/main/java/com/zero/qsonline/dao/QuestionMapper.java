package com.zero.qsonline.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zero.qsonline.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 获取所有问题
     * @return 问题集合
     */
    @Select("select IfNull((select count(*) sum from t_answer a where a.question_id = q.question_id group by a.question_id), 0) sum " +
            "     , q.question_id " +
            "     , q.question_type " +
            "     , left(q.create_time,19) create_time " +
            "     , q.question_title " +
            "     , u.user_nick_name " +
            "from t_question q " +
            "       left join t_user u on q.user_id = u.user_id " +
            "order by q.create_time desc")
    List<Map<String, Object>> getAll();

    /**
     * 根据问题类型获取数据
     * @param type 类型
     * @return 问题集合
     */
    @Select("select IfNull((select count(*) sum from t_answer a where a.question_id = q.question_id group by a.question_id), 0) sum " +
            "     , q.question_id " +
            "     , q.question_type " +
            "     , left(q.create_time,19) create_time " +
            "     , q.question_title " +
            "     , u.user_nick_name " +
            "from t_question q " +
            "       left join t_user u on q.user_id = u.user_id " +
            "where q.question_type = #{type} " +
            "order by q.create_time desc")
    List<Map<String, Object>> getByType(@Param("type") int type);
}
