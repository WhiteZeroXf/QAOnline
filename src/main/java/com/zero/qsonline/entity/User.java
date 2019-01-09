package com.zero.qsonline.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

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
    private String userGender;

    /**
     * 用户班级
     */
    private String userClassId;

    /**
     * 用户头像
     */
    private String userHeadImg;

    /**
     * 昵称
     */
    private String userNickName;


    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String PASSWORD = "password";

    public static final String USER_TYPE = "user_type";

    public static final String USER_GENDER = "user_gender";

    public static final String USER_CLASS_ID = "user_class_id";

    public static final String USER_HEAD_IMG = "user_head_img";

    public static final String USER_NICK_NAME = "user_nick_name";

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
