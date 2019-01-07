package com.zero.qsonline.entity;

import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class User extends Model<User> {

private static final long serialVersionUID=1L;

                    @TableId(value = "user_id", type = IdType.UUID)
                private String userId;
    /**
     * 用户名
     */
        private String userName;
    /**
     * 登录密码
     */
        private String password;
    /**
     * 1学生/2教师/3管理员
     */
        private Integer userType;
    /**
     * 0女/1男
     */
        private Integer userGender;
    /**
     * 用户班级
     */
        private String userClassId;
    /**
     * 用户头像
     */
    @TableField("user_headImg")
        private String userHeadimg;


    /**
     * 
     */
    public static final String USER_ID ="user_id";

    /**
     * 用户名
     */
    public static final String USER_NAME ="user_name";

    /**
     * 登录密码
     */
    public static final String PASSWORD ="password";

    /**
     * 1学生/2教师/3管理员
     */
    public static final String USER_TYPE ="user_type";

    /**
     * 0女/1男
     */
    public static final String USER_GENDER ="user_gender";

    /**
     * 用户班级
     */
    public static final String USER_CLASS_ID ="user_class_id";

    /**
     * 用户头像
     */
    public static final String USER_HEADIMG ="user_headImg";

@Override
protected Serializable pkVal(){
            return this.userId;
        }

        }
