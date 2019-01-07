package com.zero.qsonline.entity;

import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_question")
public class Question extends Model<Question> {

private static final long serialVersionUID=1L;

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
        private LocalDateTime createTime;


    /**
     * 
     */
    public static final String QUESTION_ID ="question_id";

    /**
     * 发表用户
     */
    public static final String USER_ID ="user_id";

    /**
     * 问题名称
     */
    public static final String QUESTION_TITLE ="question_title";

    /**
     * 问题内容
     */
    public static final String QUESTION_CONTEXT ="question_context";

    /**
     * 0普通/1热点/2精品
     */
    public static final String QUESTION_TYPE ="question_type";

    /**
     * 创建时间
     */
    public static final String CREATE_TIME ="create_time";

@Override
protected Serializable pkVal(){
            return this.questionId;
        }

        }
