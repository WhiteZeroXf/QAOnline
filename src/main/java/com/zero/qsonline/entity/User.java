package com.zero.qsonline.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

// 此注解标识表名
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    // 此注解标识表主键，类型为UUID
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserClassId() {
        return userClassId;
    }

    public void setUserClassId(String userClassId) {
        this.userClassId = userClassId;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
}
