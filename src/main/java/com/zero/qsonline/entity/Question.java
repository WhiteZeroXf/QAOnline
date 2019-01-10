package com.zero.qsonline.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_question")
public class Question extends Model<Question> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "question_id", type = IdType.UUID)
    private String questionId;

    /**
     * 发表用户
     */
    private String userId;

    /**
     * 问题名称
     */
    private String questionTitle;

    /**
     * 问题内容
     */
    private String questionContext;

    /**
     * 0普通/1热点/2精品
     */
    private Integer questionType;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    public static final String QUESTION_ID = "question_id";

    public static final String USER_ID = "user_id";

    public static final String QUESTION_TITLE = "question_title";

    public static final String QUESTION_CONTEXT = "question_context";

    public static final String QUESTION_TYPE = "question_type";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.questionId;
    }

}
