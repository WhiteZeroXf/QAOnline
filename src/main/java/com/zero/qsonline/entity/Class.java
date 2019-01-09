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
@TableName("t_class")
public class Class extends Model<Class> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id", type = IdType.UUID)
    private String classId;

    /**
     * 系id
     */
    private String deptId;

    /**
     * 班级名称
     */
    private String className;


    public static final String CLASS_ID = "class_id";

    public static final String DEPT_ID = "dept_id";

    public static final String CLASS_NAME = "class_name";

    @Override
    protected Serializable pkVal() {
        return this.classId;
    }

}
