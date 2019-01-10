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
@TableName("t_answer")
public class Answer extends Model<Answer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "answer_id", type = IdType.UUID)
    private String answerId;

    /**
     * 所属问题id
     */
    private String questionId;

    /**
     * 所属用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 回复
     */
    private String content;


    public static final String ANSWER_ID = "answer_id";

    public static final String QUESTION_ID = "question_id";

    public static final String USER_ID = "user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String CONTENT = "content";

    @Override
    protected Serializable pkVal() {
        return this.answerId;
    }

}
